package com.plcoding.cryptocurrencyappyt

sealed class Screen(val route: String) {
    object CoinListScreen : Screen("coin_list_screen")
    object coinDetailsScreen : Screen("coin_detail_screen")
}