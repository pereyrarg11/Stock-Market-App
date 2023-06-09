package com.pereyrarg11.stockmarketapp.presentation.company_info

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pereyrarg11.stockmarketapp.domain.repository.StockRepository
import com.pereyrarg11.stockmarketapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompanyInfoViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: StockRepository,
) : ViewModel() {

    var state by mutableStateOf(CompanyInfoState())

    init {
        viewModelScope.launch {
            val symbol = savedStateHandle.get<String>("symbol") ?: return@launch
            state = state.copy(isLoading = true)

            val companyInforesult = async { repository.getCompanyInfo(symbol) }
            when (val result = companyInforesult.await()) {
                is Resource.Error -> {
                    state = state.copy(
                        company = null,
                        isLoading = false,
                        error = result.message,
                    )
                }

                is Resource.Loading -> Unit
                is Resource.Success -> {
                    state = state.copy(
                        company = result.data,
                        isLoading = false,
                        error = null,
                    )
                }
            }

            val intradayInfoResult = async { repository.getIntradayInfo(symbol) }
            when (val result = intradayInfoResult.await()) {
                is Resource.Error -> {
                    state = state.copy(
                        stockInfos = emptyList(),
                        isLoading = false,
                        error = result.message,
                    )
                }

                is Resource.Loading -> Unit
                is Resource.Success -> {
                    state = state.copy(
                        stockInfos = result.data ?: emptyList(),
                        isLoading = false,
                        error = null,
                    )
                }
            }
        }
    }
}