package com.plcoding.cryptocurrencyappyt.domain.model

import com.google.gson.annotations.SerializedName

data class Coins(
    val id: String,
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String
)