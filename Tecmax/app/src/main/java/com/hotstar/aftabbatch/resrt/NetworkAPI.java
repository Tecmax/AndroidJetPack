package com.hotstar.aftabbatch.resrt;

import com.hotstar.aftabbatch.resrt.model.CategoryDetailResponse;
import com.hotstar.aftabbatch.resrt.model.CategoryListResponse;
import com.hotstar.aftabbatch.resrt.model.CatergoryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkAPI {

    @GET("categories.php")
    Call<CatergoryResponse> getAllCategories();


    @GET("list.php")
    Call<List<CategoryListResponse>> getCategoriesList(@Query("c") String data);


    @GET("filter.php")
    Call<CategoryDetailResponse> getCategoriesDetails(@Query("c") String data);

}
