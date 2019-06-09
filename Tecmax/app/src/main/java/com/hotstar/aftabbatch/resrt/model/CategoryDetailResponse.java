package com.hotstar.aftabbatch.resrt.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryDetailResponse {

    @SerializedName("meals")
    private List<MealDetails> meals = null;

    public List<MealDetails> getMeals() {
        return meals;
    }

    public void setMeals(List<MealDetails> meals) {
        this.meals = meals;
    }
}
