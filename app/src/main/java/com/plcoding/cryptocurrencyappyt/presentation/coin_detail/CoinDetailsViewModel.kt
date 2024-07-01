package com.plcoding.cryptocurrencyappyt.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cryptocurrencyappyt.common.Constants.PARAM_COIN_ID
import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.domain.use_case.get_coin.GetCoinDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinDetailsUseCase: GetCoinDetailsUseCase,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {
    private val _state = mutableStateOf<CoinDetailsState>(CoinDetailsState())
    val state: State<CoinDetailsState> = _state

    init {
        savedStateHandle.get<String>(PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId: String) {
        getCoinDetailsUseCase(coinId = coinId).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = CoinDetailsState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = CoinDetailsState(coin = result.data)
                }

                is Resource.Error -> {
                    _state.value =
                        CoinDetailsState(error = result.message ?: "An unexpected error occupied")
                }
            }
        }.launchIn(viewModelScope)
    }
}