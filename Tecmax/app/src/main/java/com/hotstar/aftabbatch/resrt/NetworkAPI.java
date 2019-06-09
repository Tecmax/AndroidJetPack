package com.hotstar.aftabbatch.resrt;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkAPI {

    @GET("categories.php")
    Call<CatergoryResponse> getAllCategories();


    @GET("list.php")
    Call<List<CategoryListResponse>> getCategoriesList(@Query("c") String data);

}
