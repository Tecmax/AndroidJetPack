package com.hotstar.aftabbatch.resrt;

import com.google.gson.annotations.SerializedName;

public class Meal {
    @SerializedName("strCategory")
    private String strCategory;

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }
}
