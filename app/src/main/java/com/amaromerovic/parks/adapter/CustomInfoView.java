package com.amaromerovic.parks.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.amaromerovic.parks.R;
import com.amaromerovic.parks.databinding.CustomInfoViewBinding;
import com.amaromerovic.parks.model.Park;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoView implements GoogleMap.InfoWindowAdapter {
    private final Context context;

    public CustomInfoView(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View getInfoContents(@NonNull Marker marker) {
        CustomInfoViewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.custom_info_view, null, true);

        Park park = (Park) marker.getTag();

        assert park != null;
        if (park.getDesignation().isEmpty()) {
            binding.designation.setVisibility(View.GONE);
        } else {
            binding.designation.setVisibility(View.VISIBLE);
            binding.designation.setText(park.getDesignation());
        }
        binding.state.setText(park.getAddresses().get(0).getStateCode());
        binding.city.setText(park.getAddresses().get(0).getCity());
        binding.name.setText(park.getName());

        Glide.with(context)
                .load(Uri.parse(park.getImages().get(0).getUrl()))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(android.R.drawable.stat_sys_download)
                .error(android.R.drawable.stat_notify_error)
                .override(500, 350)
                .into(binding.image);

        return binding.getRoot();
    }

    @Nullable
    @Override
    public View getInfoWindow(@NonNull Marker marker) {
        return null;
    }
}
