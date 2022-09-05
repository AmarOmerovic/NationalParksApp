package com.amaromerovic.parks.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amaromerovic.parks.databinding.ViewPagerBinding;
import com.amaromerovic.parks.model.Image;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ImageSlider> {
    private final List<Image> imagesList;
    private final Context context;

    public ViewPagerAdapter(List<Image> imagesList, Context context) {
        this.imagesList = imagesList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewPagerAdapter.ImageSlider onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        return new ImageSlider(ViewPagerBinding.inflate(layoutInflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerAdapter.ImageSlider holder, int position) {
        Glide.with(context)
                .load(Uri.parse(imagesList.get(position).getUrl()))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(android.R.drawable.stat_sys_download)
                .error(android.R.drawable.stat_notify_error)
                .override(500, 350)
                .into(holder.viewPagerBinding.viewPagerImageView);
    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }

    public class ImageSlider extends RecyclerView.ViewHolder {
        private final ViewPagerBinding viewPagerBinding;

        public ImageSlider(ViewPagerBinding viewPagerBinding) {
            super(viewPagerBinding.getRoot());
            this.viewPagerBinding = viewPagerBinding;
        }
    }

}





