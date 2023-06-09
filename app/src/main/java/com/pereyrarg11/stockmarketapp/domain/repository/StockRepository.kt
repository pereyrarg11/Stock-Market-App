package com.pereyrarg11.stockmarketapp.domain.repository

import com.pereyrarg11.stockmarketapp.domain.model.CompanyInfo
import com.pereyrarg11.stockmarketapp.domain.model.CompanyListing
import com.pereyrarg11.stockmarketapp.domain.model.IntradayInfo
import com.pereyrarg11.stockmarketapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {

    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String,
    ): Flow<Resource<List<CompanyListing>>>

    suspend fun getIntradayInfo(
        symbol: String,
    ): Resource<List<IntradayInfo>>

    suspend fun getCompanyInfo(
        symbol: String,
    ): Resource<CompanyInfo>
}