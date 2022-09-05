package com.amaromerovic.parks.model;

import androidx.annotation.NonNull;

public class Image {
    public String credit;
    public String title;
    public String altText;
    public String caption;
    public String url;

    public Image(String credit, String title, String altText, String caption, String url) {
        this.credit = credit;
        this.title = title;
        this.altText = altText;
        this.caption = caption;
        this.url = url;
    }

    public Image() {
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @NonNull
    @Override
    public String toString() {
        return "Image{" +
                "credit='" + credit + '\'' +
                ", title='" + title + '\'' +
                ", altText='" + altText + '\'' +
                ", caption='" + caption + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}