package com.soumitra.nearbyplaces.common

import com.soumitra.nearbyplaces.remote.GoogleAPIService
import com.soumitra.nearbyplaces.remote.RetrofitClient

object Common {

    private const val GOOGLE_API_URL = "https://maps.googleapis.com/"

    val googleApiService: GoogleAPIService
        get() = RetrofitClient.getClient(GOOGLE_API_URL).create(GoogleAPIService::class.java)
}