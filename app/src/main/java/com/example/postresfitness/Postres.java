package com.example.postresfitness;

import android.graphics.drawable.Drawable;

public class Postres {

    private int image;
    private String info;

    public Postres(int image, String info){
        this.image = image;
        this.info = info;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
