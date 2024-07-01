package com.plcoding.cryptocurrencyappyt.data.remote

import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetailsDto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaAPI {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinsDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailsDto
}