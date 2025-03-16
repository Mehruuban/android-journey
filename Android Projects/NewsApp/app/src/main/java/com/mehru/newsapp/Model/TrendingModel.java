package com.mehru.newsapp.Model;

public class TrendingModel {

    int id;
    String trendingCategory , trendingImageUrl,trendingTitle , trendingDate;

    public TrendingModel(int id, String trendingCategory, String trendingImageUrl, String trendingTitle, String trendingDate) {
        this.id = id;
        this.trendingCategory = trendingCategory;
        this.trendingImageUrl = trendingImageUrl;
        this.trendingTitle = trendingTitle;
        this.trendingDate = trendingDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrendingCategory() {
        return trendingCategory;
    }

    public void setTrendingCategory(String trendingCategory) {
        this.trendingCategory = trendingCategory;
    }

    public String getTrendingImageUrl() {
        return trendingImageUrl;
    }

    public void setTrendingImageUrl(String trendingImageUrl) {
        this.trendingImageUrl = trendingImageUrl;
    }

    public String getTrendingTitle() {
        return trendingTitle;
    }

    public void setTrendingTitle(String trendingTitle) {
        this.trendingTitle = trendingTitle;
    }

    public String getTrendingDate() {
        return trendingDate;
    }

    public void setTrendingDate(String trendingDate) {
        this.trendingDate = trendingDate;
    }
}
