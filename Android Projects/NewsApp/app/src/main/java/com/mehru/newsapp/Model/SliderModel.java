package com.mehru.newsapp.Model;

public class SliderModel {
    int id ;
    String imageURL;

    public SliderModel(int id, int imageURL) {
        this.id = id;
        this.imageURL = String.valueOf(imageURL);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
