package com.sopt.soptmon.daehwan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.soptmon.ApiPool
import com.sopt.soptmon.ResponseCallBack
import retrofit2.Call
import retrofit2.Response

class HomeViewModel(
    private val _result: MutableLiveData<HomeSuggestionResponse> = MutableLiveData<HomeSuggestionResponse>(),
    private val homeSuggestionApi: HomeApi = ApiPool.HomeApi
) : ViewModel() {

    val result: LiveData<HomeSuggestionResponse>
        get() = _result

    fun getSuggestions() {
        homeSuggestionApi.getSuggestions()
            .enqueue(
                object : ResponseCallBack<HomeSuggestionResponse>() {
                    override fun onResponse(
                        call: Call<HomeSuggestionResponse>,
                        response: Response<HomeSuggestionResponse>
                    ) {
                        if (response.isSuccessful) {
                            _result.value = response.body()
                        } else {
                            _result.value = HomeSuggestionResponse(
                                response.code(),
                                response.isSuccessful,
                                response.message(),
                                null
                            )
                        }

                    }
                }
            )
    }
}

class HomeTvOnViewModel(
    private val _result: MutableLiveData<TvOnResponse> = MutableLiveData<TvOnResponse>(),
    private val homeTvOnApi: HomeApi = ApiPool.HomeApi
) : ViewModel() {
    val result: LiveData<TvOnResponse>
        get() = _result

    fun getTvOns() {
        homeTvOnApi.getTvOns()
            .enqueue(
                object : ResponseCallBack<TvOnResponse>() {
                    override fun onResponse(
                        call: Call<TvOnResponse>,
                        response: Response<TvOnResponse>
                    ) {
                        if (response.isSuccessful) {
                            _result.value = response.body()
                        } else {
                            _result.value = TvOnResponse(
                                response.code(),
                                response.isSuccessful,
                                response.message(),
                                null
                            )
                        }
                    }
                }
            )
    }
}