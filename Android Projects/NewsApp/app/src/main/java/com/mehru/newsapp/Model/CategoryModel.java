package com.mehru.newsapp.Model;

public class CategoryModel {
    int categoryID;
    String categoryName;
    String CategoryImageUrl;

    public CategoryModel(int categoryID, String categoryName, String categoryImageUrl) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        CategoryImageUrl = categoryImageUrl;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImageUrl() {
        return CategoryImageUrl;
    }

    public void setCategoryImageUrl(String categoryImageUrl) {
        CategoryImageUrl = categoryImageUrl;
    }
}
