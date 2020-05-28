package com.leeyunbo.realmvvmpractice.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    companion object {
        private var retrofit : Retrofit? = null

        fun getRetrofit() : Retrofit =
            retrofit ?: synchronized(this) {
                Retrofit
                    .Builder()
                    .baseUrl("http://192.168.219.103:8080")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
    }
}