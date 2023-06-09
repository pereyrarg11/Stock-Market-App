package com.pereyrarg11.stockmarketapp.presentation.company_info

import com.pereyrarg11.stockmarketapp.domain.model.CompanyInfo
import com.pereyrarg11.stockmarketapp.domain.model.IntradayInfo

data class CompanyInfoState(
    val stockInfos: List<IntradayInfo> = emptyList(),
    val company: CompanyInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)
