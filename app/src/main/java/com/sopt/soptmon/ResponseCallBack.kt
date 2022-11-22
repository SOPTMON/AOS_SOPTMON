package com.sopt.soptmon

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.net.ConnectException

abstract class ResponseCallBack<T> : Callback<T> {
    abstract override fun onResponse(call: Call<T>, response: Response<T>)

    override fun onFailure(call: Call<T>, t: Throwable) {
        if (t.cause is ConnectException || t.cause is HttpException) {
            Log.e(
                "NETWORK ERROR", "connection error \n " +
                        "[url] : ${call.request().url} \n" +
                        "[headers] ${call.request().headers.toMultimap()} \n", t
            )
        } else {
            Log.e("ERROR", t.message, t)
        }
    }
}