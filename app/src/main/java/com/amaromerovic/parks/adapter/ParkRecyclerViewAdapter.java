package com.amaromerovic.parks.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amaromerovic.parks.databinding.ParkRowBinding;
import com.amaromerovic.parks.model.Park;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class ParkRecyclerViewAdapter extends RecyclerView.Adapter<ParkRecyclerViewAdapter.ViewHolder> {
    private final List<Park> parksList;
    private final OnParkClickListener onParkClickListener;
    private final Context context;

    public ParkRecyclerViewAdapter(List<Park> parksList, OnParkClickListener onParkClickListener, Context context) {
        this.parksList = parksList;
        this.onParkClickListener = onParkClickListener;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ParkRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.parkRowBinding.nameTextView.setText(parksList.get(position).getName());
        if (parksList.get(position).getDesignation().isEmpty()) {
            holder.parkRowBinding.designationTextView.setVisibility(View.GONE);
        } else {
            if (holder.parkRowBinding.designationTextView.getVisibility() == View.GONE) {
                holder.parkRowBinding.designationTextView.setVisibility(View.VISIBLE);
            }
            holder.parkRowBinding.designationTextView.setText(parksList.get(position).getDesignation());
        }
        holder.parkRowBinding.stateTextView.setText(parksList.get(position).getAddresses().get(0).getStateCode());
        holder.parkRowBinding.cityTextView.setText(parksList.get(position).getAddresses().get(0).getCity());
        if (parksList.get(position).getImages().size() > 0) {
            Glide.with(context)
                    .load(Uri.parse(parksList.get(position).getImages().get(0).getUrl()))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(android.R.drawable.stat_sys_download)
                    .error(android.R.drawable.stat_notify_error)
                    .override(500, 350)
                    .into(holder.parkRowBinding.parkImageView);
        }

    }

    @Override
    public int getItemCount() {
        return parksList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ParkRowBinding parkRowBinding;

        public ViewHolder(ParkRowBinding parkRowBinding) {
            super(parkRowBinding.getRoot());
            this.parkRowBinding = parkRowBinding;
            parkRowBinding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onParkClickListener.onParkClicked(parksList.get(getAdapterPosition()));
        }
    }
}
