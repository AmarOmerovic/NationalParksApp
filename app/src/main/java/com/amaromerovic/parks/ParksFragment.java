package com.amaromerovic.parks;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.amaromerovic.parks.adapter.OnParkClickListener;
import com.amaromerovic.parks.adapter.ParkRecyclerViewAdapter;
import com.amaromerovic.parks.databinding.FragmentParksBinding;
import com.amaromerovic.parks.model.Park;
import com.amaromerovic.parks.model.ParkViewModel;

import java.util.ArrayList;
import java.util.List;

public class ParksFragment extends Fragment implements OnParkClickListener {
    private FragmentParksBinding binding;
    private ParkViewModel parkViewModel;
    private ParkRecyclerViewAdapter parkRecyclerViewAdapter;
    private List<Park> parkList;


    public static ParksFragment newInstance() {
        return new ParksFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parkList = new ArrayList<>();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        parkViewModel = new ViewModelProvider(requireActivity()).get(ParkViewModel.class);
        if (parkViewModel.getParkList().getValue() != null) {
            parkList = parkViewModel.getParkList().getValue();
            parkRecyclerViewAdapter = new ParkRecyclerViewAdapter(parkList, this, getContext());
            binding.parkRecycler.setAdapter(parkRecyclerViewAdapter);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentParksBinding.inflate(inflater, container, false);

        binding.parkRecycler.setHasFixedSize(true);
        binding.parkRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        binding = null;
        super.onDestroy();
    }

    @Override
    public void onParkClicked(Park park) {
        Log.d("TestTest", "onParkClicked: " + park.getName());
        parkViewModel.setPark(park);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentView, DetailsFragment.newInstance()).commit();
    }
}