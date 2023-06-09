package com.pereyrarg11.stockmarketapp.data.remote

import com.pereyrarg11.stockmarketapp.data.remote.dto.CompanyInfoDto
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface StockApi {

    @GET("query?function=LISTING_STATUS")
    suspend fun getListings(
        @Query("apikey") apiKey: String = API_KEY,
    ): ResponseBody // this will provide access to the byte stream only

    @GET("query?function=TIME_SERIES_INTRADAY&interval=60min&datatype=csv")
    suspend fun getIntradayInfo(
        @Query("symbol") symbol: String,
        @Query("apikey") apiKey: String = API_KEY,
    ): ResponseBody

    @GET("query?function=OVERVIEW")
    suspend fun getCompanyInfo(
        @Query("symbol") symbol: String,
        @Query("apikey") apiKey: String = API_KEY,
    ): CompanyInfoDto

    companion object {
        const val API_KEY = "BE7V9E7FXZ8DO8WA"
        const val BASE_URL = "https://www.alphavantage.co/"
    }
}