package com.plcoding.cryptocurrencyappyt.domain.repository

import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetailsDto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinsDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinsDto>
    suspend fun getCoinDetails(coinId: String): CoinDetailsDto
}