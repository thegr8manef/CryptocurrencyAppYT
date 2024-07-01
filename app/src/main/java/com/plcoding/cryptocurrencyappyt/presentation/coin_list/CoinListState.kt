package com.plcoding.cryptocurrencyappyt.presentation.coin_list

import com.plcoding.cryptocurrencyappyt.domain.model.Coins

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coins> = emptyList(),
    val error: String = ""
)
