package com.maersk.androidmng.rest.model.categoryresponse;

import com.google.gson.annotations.SerializedName;

public class Categories {

    @SerializedName("categories")
    private Category categories;

    public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }
}
