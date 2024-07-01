package com.plcoding.cryptocurrencyappyt.domain.use_case.get_coin

import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoinDetails
import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetails
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailsUseCase @Inject constructor(private val coinRepository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Resource.Loading<CoinDetails>())
            val coin = coinRepository.getCoinDetails(coinId).toCoinDetails()
            emit(Resource.Success<CoinDetails>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetails>(e.localizedMessage ?: "An unexpected error occupied"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetails>("Couldn't reach server. check your internet connection"))
        }
    }
}