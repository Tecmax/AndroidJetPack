package com.maersk.androidmng.rest.model.categoryresponse;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CategoriesResponse {
    @SerializedName("categories")
    private ArrayList<Categories> categories;

    public ArrayList<Categories> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Categories> categories) {
        this.categories = categories;
    }
}
