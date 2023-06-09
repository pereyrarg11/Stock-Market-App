package com.pereyrarg11.stockmarketapp.data.mapper

import com.pereyrarg11.stockmarketapp.data.local.CompanyListingEntity
import com.pereyrarg11.stockmarketapp.data.remote.dto.CompanyInfoDto
import com.pereyrarg11.stockmarketapp.domain.model.CompanyInfo
import com.pereyrarg11.stockmarketapp.domain.model.CompanyListing

fun CompanyListingEntity.toCompanyListing(): CompanyListing {
    return CompanyListing(
        name = name,
        symbol = symbol,
        exchange = exchange,
    )
}

fun CompanyListing.toCompanyListingEntity(): CompanyListingEntity {
    return CompanyListingEntity(
        name = name,
        symbol = symbol,
        exchange = exchange,
    )
}

fun CompanyInfoDto.toCompanyInfo(): CompanyInfo {
    return CompanyInfo(
        symbol = symbol.orEmpty(),
        description = description.orEmpty(),
        name = name.orEmpty(),
        country = country.orEmpty(),
        industry = industry.orEmpty(),
    )
}