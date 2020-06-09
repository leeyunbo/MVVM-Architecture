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
                    .baseUrl("https://api.nexon.co.kr/fifaonline4/v1.0/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
    }
}