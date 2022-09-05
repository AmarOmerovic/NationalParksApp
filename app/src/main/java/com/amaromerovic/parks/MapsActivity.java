package com.amaromerovic.parks;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import com.amaromerovic.parks.adapter.CustomInfoView;
import com.amaromerovic.parks.data.Repository;
import com.amaromerovic.parks.databinding.ActivityMapsBinding;
import com.amaromerovic.parks.model.Park;
import com.amaromerovic.parks.model.ParkViewModel;
import com.amaromerovic.parks.util.Util;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {
    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private ParkViewModel parkViewModel;
    private List<Park> parkList;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        checkForInternetConnection();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        timeOut(20000, 1000);

        parkViewModel = new ViewModelProvider(this).get(ParkViewModel.class);
        parkList = new ArrayList<>();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentView);

        assert mapFragment != null;
        mapFragment.getMapAsync(this);

        binding.bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int id = item.getItemId();
            if (id == R.id.mapButton) {
                if (binding.progressView.getVisibility() == View.GONE) {
                    binding.progressView.setVisibility(View.VISIBLE);
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                    countDownTimer.cancel();
                    timeOut(20000, 1000);
                }
                mMap.clear();
                if (binding.searchBar.getRoot().getVisibility() == View.GONE) {
                    binding.searchBar.getRoot().setVisibility(View.VISIBLE);
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentView, mapFragment).commit();
                mapFragment.getMapAsync(this);
                return true;
            } else if (id == R.id.parksButton) {
                selectedFragment = ParksFragment.newInstance();
                if (binding.searchBar.getRoot().getVisibility() == View.VISIBLE) {
                    binding.searchBar.getRoot().setVisibility(View.GONE);
                }
            }
            assert selectedFragment != null;
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentView, selectedFragment).commit();
            return true;
        });

        binding.searchBar.searchBarSearchButton.setOnClickListener(view -> {
            if (!TextUtils.isEmpty(binding.searchBar.searchBarStateView.getText())) {
                Util.setStateCode(binding.searchBar.searchBarStateView.getText().toString().toUpperCase(Locale.ROOT).trim());
                mMap.clear();
                mapFragment.getMapAsync(this);
                binding.searchBar.searchBarStateView.setHint("State code:");
                binding.searchBar.searchBarStateView.setText("");
                Util.hideSoftKeyboard(view);
            } else {
                mMap.clear();
                Util.setStateCode("NY");
                mapFragment.getMapAsync(this);
            }
            if (binding.progressView.getVisibility() == View.GONE) {
                binding.progressView.setVisibility(View.VISIBLE);
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                countDownTimer.cancel();
                timeOut(20000, 1000);
            }
        });

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setInfoWindowAdapter(new CustomInfoView(getApplicationContext()));
        mMap.setOnInfoWindowClickListener(this);
        mMap.setOnMarkerClickListener(marker -> {
            marker.showInfoWindow();
            new Handler(Looper.getMainLooper()).postDelayed(marker::showInfoWindow, 100);
            return true;
        });

        parkList.clear();
        Repository.getPark(Util.PARKS_URL, parks -> {
            if (parks.isEmpty()) {
                alert("Bad state code!", "You have entered an invalid state code!", "I understand");
            }
            parkList = parks;
            Park park;
            for (int i = 0; i < parks.size(); i++) {

                park = parks.get(i);

                Glide.with(getApplicationContext())
                        .load(Uri.parse(park.getImages().get(0).getUrl()))
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .preload(500, 350);

                LatLng coordinates = new LatLng(Double.parseDouble(park.getLatitude()), Double.parseDouble(park.getLongitude()));
                MarkerOptions markerOptions = new MarkerOptions()
                        .position(coordinates)
                        .icon(bitmapDescriptorFromVector(this, R.drawable.ic_baseline_flag_24));

                Marker marker = mMap.addMarker(markerOptions);
                assert marker != null;
                marker.setTag(park);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 5f));
            }
            parkViewModel.setParkList(parkList);
            if (binding.progressView.getVisibility() == View.VISIBLE) {
                binding.progressView.setVisibility(View.GONE);
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            }
        });

    }

    @Override
    public void onInfoWindowClick(@NonNull Marker marker) {
        parkViewModel.setPark((Park) marker.getTag());
        if (binding.searchBar.getRoot().getVisibility() == View.VISIBLE) {
            binding.searchBar.getRoot().setVisibility(View.GONE);
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentView, DetailsFragment.newInstance()).commit();
    }

    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        assert vectorDrawable != null;
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    public boolean isConnected() throws InterruptedException, IOException {
        String command = "ping -c 1 google.com";
        return Runtime.getRuntime().exec(command).waitFor() == 0;
    }

    private void checkForInternetConnection() {
        try {
            if (!isConnected()) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MapsActivity.this);
                dialog.setCancelable(false);
                dialog.setTitle("No internet connection!");
                dialog.setMessage("There is a problem with your internet connection. Please make sure that you provide a stable internet connection before you keep using the app.");
                dialog.setPositiveButton("I understand", (dialog1, id) -> finish());
                final AlertDialog alert = dialog.create();
                alert.show();
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    private void alert(String title, String message, String buttonText) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MapsActivity.this);
        dialog.setCancelable(false);
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setPositiveButton(buttonText, (dialog1, id) -> {
            //
        });
        final AlertDialog alert = dialog.create();
        alert.show();
    }

    private void timeOut(int timeToCount, int counter) {
        if (binding.progressView.getVisibility() == View.VISIBLE) {
            countDownTimer = new CountDownTimer(timeToCount, counter) {
                public void onTick(long millisUntilFinished) {
                    //
                }

                public void onFinish() {
                    if (binding.progressView.getVisibility() == View.VISIBLE) {
                        binding.progressView.setVisibility(View.GONE);
                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                        alert("Error!", "Oops, something went wrong.\nPlease try again!", "Ok");
                    }
                }
            }.start();
        }
    }

}