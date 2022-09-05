package com.amaromerovic.parks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.amaromerovic.parks.adapter.ViewPagerAdapter;
import com.amaromerovic.parks.databinding.FragmentDetailsBinding;
import com.amaromerovic.parks.model.ParkViewModel;


public class DetailsFragment extends Fragment {
    private FragmentDetailsBinding binding;
    private ParkViewModel parkViewModel;
    private ViewPagerAdapter viewPagerAdapter;


    public static DetailsFragment newInstance() {
        return new DetailsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        parkViewModel = new ViewModelProvider(requireActivity()).get(ParkViewModel.class);
        parkViewModel.getPark().observe(getViewLifecycleOwner(), park -> {

            //Header Text
            binding.parkNameTextView.setText(park.getName());
            binding.parkDesignationText.setText(park.getDesignation());


            //Image
            viewPagerAdapter = new ViewPagerAdapter(park.getImages(), getContext());
            binding.imageViewPager.setAdapter(viewPagerAdapter);


            //Description
            binding.parkDescriptionView.setText(park.getDescription());


            //Activities
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < park.getActivities().size(); i++) {
                stringBuilder.append("⬤ ").append(park.getActivities().get(i).getName());
                if (!(i == (park.getActivities().size() - 1))) {
                    stringBuilder.append("\n\n");
                }
            }
            binding.activitiesTextView.setText(stringBuilder);


            //Topics
            stringBuilder = new StringBuilder();
            for (int i = 0; i < park.getTopics().size(); i++) {
                stringBuilder.append("⬤ ").append(park.getTopics().get(i).getName());
                if (!(i == (park.getTopics().size() - 1))) {
                    stringBuilder.append("\n\n");
                }
            }
            binding.topicsTextView.setText(stringBuilder);


            //Weather
            binding.weatherInfo.setText(park.getWeatherInfo());


            //Address
            stringBuilder = new StringBuilder();
            for (int i = 0; i < park.getAddresses().size(); i++) {
                stringBuilder.append("#").append(i + 1).append("\n")
                        .append("Postal code: ").append(park.getAddresses().get(i).getPostalCode()).append("\n")
                        .append("City: ").append(park.getAddresses().get(i).getCity()).append("\n")
                        .append("State code: ").append(park.getAddresses().get(i).getStateCode()).append("\n")
                        .append("Line1: ").append(park.getAddresses().get(i).getLine1()).append("\n")
                        .append("Type: ").append(park.getAddresses().get(i).getType()).append("\n")
                        .append("Line3: ").append(park.getAddresses().get(i).getLine3()).append("\n")
                        .append("Line2: ").append(park.getAddresses().get(i).getLine2());
                if (!(i == (park.getAddresses().size() - 1))) {
                    stringBuilder.append("\n\n");
                }
            }
            binding.address.setText(stringBuilder);


            //Direction
            binding.directionInfo.setText(park.getDirectionsInfo());


            //Operating Hours
            //Standard Hours
            stringBuilder = new StringBuilder();
            stringBuilder.append("⬤ ").append("Monday: ").append(park.getOperatingHours().get(0).getStandardHours().getFriday()).append("\n")
                    .append("⬤ ").append("Tuesday: ").append(park.getOperatingHours().get(0).getStandardHours().getTuesday()).append("\n")
                    .append("⬤ ").append("Wednesday: ").append(park.getOperatingHours().get(0).getStandardHours().getWednesday()).append("\n")
                    .append("⬤ ").append("Thursday: ").append(park.getOperatingHours().get(0).getStandardHours().getThursday()).append("\n")
                    .append("⬤ ").append("Friday: ").append(park.getOperatingHours().get(0).getStandardHours().getFriday()).append("\n")
                    .append("⬤ ").append("Saturday: ").append(park.getOperatingHours().get(0).getStandardHours().getSaturday()).append("\n")
                    .append("⬤ ").append("Sunday: ").append(park.getOperatingHours().get(0).getStandardHours().getSunday()).append("\n");
            binding.standardHours.setText(stringBuilder);
            //Exception Hours
            stringBuilder = new StringBuilder();
            for (int i = 0; i < park.getOperatingHours().size(); i++) {
                for (int j = 0; j < park.getOperatingHours().get(i).getExceptions().size(); j++) {
                    stringBuilder.append("⬤ ").append(park.getOperatingHours().get(i).getExceptions().get(j).getName()).append(" ⬤").append("\n")
                            .append("\t").append("Monday: ").append(park.getOperatingHours().get(i).getExceptions().get(j).getExceptionHours().getFriday()).append("\n")
                            .append("\t").append("Tuesday: ").append(park.getOperatingHours().get(i).getExceptions().get(j).getExceptionHours().getTuesday()).append("\n")
                            .append("\t").append("Wednesday: ").append(park.getOperatingHours().get(i).getExceptions().get(j).getExceptionHours().getWednesday()).append("\n")
                            .append("\t").append("Thursday: ").append(park.getOperatingHours().get(i).getExceptions().get(j).getExceptionHours().getThursday()).append("\n")
                            .append("\t").append("Friday: ").append(park.getOperatingHours().get(i).getExceptions().get(j).getExceptionHours().getFriday()).append("\n")
                            .append("\t").append("Saturday: ").append(park.getOperatingHours().get(i).getExceptions().get(j).getExceptionHours().getSaturday()).append("\n")
                            .append("\t").append("Sunday: ").append(park.getOperatingHours().get(i).getExceptions().get(j).getExceptionHours().getSunday()).append("\n")
                            .append("\t").append("Start date: ").append(park.getOperatingHours().get(i).getExceptions().get(j).getStartDate()).append("\n")
                            .append("\t").append("End date: ").append(park.getOperatingHours().get(i).getExceptions().get(j).getEndDate());
                    if (!(j == (park.getOperatingHours().get(i).getExceptions().size() - 1))) {
                        stringBuilder.append("\n\n");
                    }
                }
                if (!(i == (park.getOperatingHours().size() - 1))) {
                    stringBuilder.append("\n\n");
                }
            }
            binding.exceptions.setText(stringBuilder);


            //Entrance fees
            stringBuilder = new StringBuilder();
            for (int i = 0; i < park.getEntranceFees().size(); i++) {
                stringBuilder.append("⬤ ").append(park.getEntranceFees().get(i).getTitle()).append(" ⬤")
                        .append("\n").append("Description: ").append(park.getEntranceFees().get(i).getDescription()).append("\n")
                        .append("Price: ").append(park.getEntranceFees().get(i).getCost()).append("$");
                if (!(i == (park.getEntranceFees().size() - 1))) {
                    stringBuilder.append("\n\n");
                }
            }
            binding.entranceFee.setText(stringBuilder);


            //Entrance passes
            stringBuilder = new StringBuilder();
            for (int i = 0; i < park.getEntrancePasses().size(); i++) {
                stringBuilder.append("⬤ ").append(park.getEntrancePasses().get(i).getTitle()).append(" ⬤")
                        .append("\n").append("Description: ").append(park.getEntrancePasses().get(i).getDescription()).append("\n")
                        .append("Price: ").append(park.getEntrancePasses().get(i).getCost()).append("$");
                if (!(i == (park.getEntrancePasses().size() - 1))) {
                    stringBuilder.append("\n\n");
                }
            }
            binding.entrancePass.setText(stringBuilder);


            //Contact info
            //Phone number
            stringBuilder = new StringBuilder();
            for (int i = 0; i < park.getContacts().getPhoneNumbers().size(); i++) {
                stringBuilder.append("#").append(i + 1).append("\n")
                        .append("Number: ").append(park.getContacts().getPhoneNumbers().get(i).getPhoneNumber()).append("\n")
                        .append("Type: ").append(park.getContacts().getPhoneNumbers().get(i).getType());
                if (!(i == (park.getContacts().getPhoneNumbers().size() - 1))) {
                    stringBuilder.append("\n\n");
                }
            }
            binding.phoneNumber.setText(stringBuilder);
            //Email
            stringBuilder = new StringBuilder();
            for (int i = 0; i < park.getContacts().getEmailAddresses().size(); i++) {
                stringBuilder.append("#").append(i + 1).append("\n")
                        .append("Email address: ").append(park.getContacts().getEmailAddresses().get(i).getEmailAddress());
                if (!(i == (park.getContacts().getEmailAddresses().size() - 1))) {
                    stringBuilder.append("\n\n");
                }
            }
            binding.email.setText(stringBuilder);
        });


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        binding = null;
        super.onDestroy();
    }
}