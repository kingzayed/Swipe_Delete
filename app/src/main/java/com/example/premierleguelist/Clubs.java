package com.example.premierleguelist;

import java.io.Serializable;

public class Clubs implements Serializable {

    private String names;
    private int images;

    public Clubs(String names, int images) {
        this.names = names;
        this.images = images;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
