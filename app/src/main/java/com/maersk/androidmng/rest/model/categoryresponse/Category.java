package com.maersk.androidmng.rest.model.categoryresponse;

import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("id")
    private int categoryId;

    @SerializedName("name")
    private String name;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
