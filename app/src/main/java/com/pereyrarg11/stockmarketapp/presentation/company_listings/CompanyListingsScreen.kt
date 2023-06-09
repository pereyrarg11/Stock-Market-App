package com.pereyrarg11.stockmarketapp.presentation.company_listings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pereyrarg11.stockmarketapp.presentation.company_listings.components.CompanyItem
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterialApi::class)
@Composable
@Destination
fun CompanyListingsScreen(
    navigator: DestinationsNavigator,
    viewModel: CompanyListingsViewModel = hiltViewModel()
) {

    val state = viewModel.state
    val isRefreshing = state.isRefreshing
    val pullRefreshState = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = { viewModel.onEvent(CompanyListingsEvent.Refresh) }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .pullRefresh(pullRefreshState),
    ) {
        OutlinedTextField(
            value = state.searchQuery,
            onValueChange = {
                viewModel.onEvent(
                    CompanyListingsEvent.OnSearchQueryChange(it)
                )
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            placeholder = {
                Text(text = "Search")
            },
            maxLines = 1,
            singleLine = true,
        )
        PullRefreshIndicator(refreshing = isRefreshing, state = pullRefreshState)
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.companies.size) { index ->
                val company = state.companies[index]
                CompanyItem(
                    company = company,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            // TODO: navigate to details screen
                        }
                        .padding(16.dp),
                )

                if (index < state.companies.size) {
                    Divider(modifier = Modifier.padding(horizontal = 16.dp))
                }
            }
        }
    }
}