package com.pereyrarg11.stockmarketapp.data.remote

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface StockApi {

    @GET("query?function=LISTING_STATUS")
    suspend fun getListings(
        @Query("api_key") apiKey: String,
    ): ResponseBody // this will provide access to the byte stream only

    companion object {
        const val API_KEY = "MVKQMYYMPBNH22AK"
        const val BASE_URL = "https://alphavantage.co"
    }
}