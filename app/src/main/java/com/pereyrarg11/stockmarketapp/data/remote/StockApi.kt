package com.pereyrarg11.stockmarketapp.data.remote

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface StockApi {

    @GET("query?function=LISTING_STATUS")
    suspend fun getListings(
        @Query("apikey") apiKey: String = API_KEY,
    ): ResponseBody // this will provide access to the byte stream only

    companion object {
        const val API_KEY = "BE7V9E7FXZ8DO8WA"
        const val BASE_URL = "https://www.alphavantage.co/"
    }
}