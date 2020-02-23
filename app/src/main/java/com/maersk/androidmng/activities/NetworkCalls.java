package com.maersk.androidmng.activities;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface NetworkCalls {

    @Headers("user-key:d553d21b7e7d78154559d98277b8d1c8")
    @GET("collections")
    Call<CollectionResponse> getCollections(@Query("city_id") int cityId);


    @Headers("user-key:d553d21b7e7d78154559d98277b8d1c8")
    @GET("categories")
    Call<CollectionResponse> getCategories();

}
