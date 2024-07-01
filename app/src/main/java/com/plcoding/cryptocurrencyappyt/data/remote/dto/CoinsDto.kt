package com.plcoding.cryptocurrencyappyt.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.plcoding.cryptocurrencyappyt.domain.model.Coins

data class CoinsDto(
    val id: String,
    @SerializedName("is_active") val is_active: Boolean,
    @SerializedName("is_new") val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinsDto.toCoins(): Coins {
    return Coins(id = id, is_active = is_active, name = name, rank = rank, symbol = symbol)
}