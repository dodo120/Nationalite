package com.uppa.nationalite;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NationalityApi {
    @GET(".")
    Call<Response> getCountry(@Query("name") String name);
}
