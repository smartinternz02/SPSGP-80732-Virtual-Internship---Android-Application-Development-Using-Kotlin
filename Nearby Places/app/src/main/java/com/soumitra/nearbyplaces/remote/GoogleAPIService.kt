package com.soumitra.nearbyplaces.remote

import com.soumitra.nearbyplaces.model.MyPlaces
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface GoogleAPIService {

    @GET
    fun getNearByPlaces(@Url url: String): Call<MyPlaces>
}