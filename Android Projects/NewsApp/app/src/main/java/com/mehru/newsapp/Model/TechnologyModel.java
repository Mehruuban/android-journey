package com.mehru.newsapp.Model;

public class TechnologyModel {
    int id ;
    String ImageUrl ,Title ;

    public TechnologyModel(int id, String imageUrl, String title) {
        this.id = id;
        ImageUrl = imageUrl;
        Title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
