package com.plcoding.cryptocurrencyappyt.domain.use_case.get_coins

import android.util.Log
import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoins
import com.plcoding.cryptocurrencyappyt.domain.model.Coins
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val coinRepository: CoinRepository) {
    operator fun invoke(): Flow<Resource<List<Coins>>> = flow {
        try {
            emit(Resource.Loading<List<Coins>>())
            val coins = coinRepository.getCoins().map { it.toCoins() }
            emit(Resource.Success<List<Coins>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coins>>(e.localizedMessage ?: "An unexpected error occupied"))
            Log.d("error_manef", e.toString())
        } catch (e: IOException) {
            emit(Resource.Error<List<Coins>>("Couldn't reach server. check your internet connection"))
            Log.d("error_manef", e.toString())
        }
    }
}