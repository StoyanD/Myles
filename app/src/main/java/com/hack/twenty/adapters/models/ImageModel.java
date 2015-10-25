package com.hack.twenty.adapters.models;

import android.graphics.Bitmap;

/**
 * Created by stoyan on 10/24/15.
 */
public class ImageModel {
    private Bitmap image;
    private String title;

    public ImageModel(Bitmap image, String title) {
        super();
        this.image = image;
        this.title = title;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}