package com.hotstar.aftabbatch.resrt;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CatergoryResponse {
    @SerializedName("categories")
    private List<Category> categories = null;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
