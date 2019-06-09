package com.hotstar.aftabbatch.resrt;

import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("idCategory")
    private String categoryId;
    @SerializedName("strCategory")
    private String strCategory;
    @SerializedName("strCategoryThumb")
    private String strCategoryThumb;
    @SerializedName("strCategoryDescription")
    private String strCategoryDescription;

    public String getIdCategory() {
        return categoryId;
    }

    public void setIdCategory(String idCategory) {
        this.categoryId = idCategory;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrCategoryThumb() {
        return strCategoryThumb;
    }

    public void setStrCategoryThumb(String strCategoryThumb) {
        this.strCategoryThumb = strCategoryThumb;
    }

    public String getStrCategoryDescription() {
        return strCategoryDescription;
    }

    public void setStrCategoryDescription(String strCategoryDescription) {
        this.strCategoryDescription = strCategoryDescription;
    }
}
