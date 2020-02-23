package com.maersk.androidmng.rest.api;

import com.maersk.androidmng.activities.CollectionResponse;
import com.maersk.androidmng.rest.model.categoryresponse.CategoriesResponse;
import com.maersk.androidmng.rest.model.citis.CityResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface BasePaths {

    @Headers("user-key:4917240ebb7de67e254c9541935ad8a0")
    @GET("collections")
    Call<CollectionResponse> getCollections(@Query("city_id") int cityId);


    @Headers("user-key:d553d21b7e7d78154559d98277b8d1c8")
    @GET("categories")
    Call<CategoriesResponse> getCategoriesRes();


    @Headers("user-key:4917240ebb7de67e254c9541935ad8a0")
    @GET("cities")
    Call<CityResponse> getCities(@Query("q") String cityName);

}
