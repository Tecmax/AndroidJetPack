package com.hotstar.aftabbatch.resrt.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryListResponse {
    @SerializedName("meals")
    private List<Meal> meals = null;

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
}
