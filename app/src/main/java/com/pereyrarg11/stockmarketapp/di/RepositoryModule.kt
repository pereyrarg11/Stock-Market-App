package com.pereyrarg11.stockmarketapp.di

import com.pereyrarg11.stockmarketapp.data.csv.CompanyListingParser
import com.pereyrarg11.stockmarketapp.data.csv.CsvParser
import com.pereyrarg11.stockmarketapp.data.csv.IntradayInfoParser
import com.pereyrarg11.stockmarketapp.data.repository.StockRepositoryImpl
import com.pereyrarg11.stockmarketapp.domain.model.CompanyListing
import com.pereyrarg11.stockmarketapp.domain.model.IntradayInfo
import com.pereyrarg11.stockmarketapp.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingsParser(
        parser: CompanyListingParser,
    ): CsvParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        repository: StockRepositoryImpl,
    ): StockRepository

    @Binds
    @Singleton
    abstract fun bindIntradayParser(
        parser: IntradayInfoParser,
    ): CsvParser<IntradayInfo>
}