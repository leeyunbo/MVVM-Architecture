package com.leeyunbo.realmvvmpractice.viewmodel

import android.util.Log
import com.leeyunbo.realmvvmpractice.api.Api
import com.leeyunbo.realmvvmpractice.data.UserVO
import com.leeyunbo.realmvvmpractice.util.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel {
    private val service =
        RetrofitFactory.getRetrofit().create(Api::class.java)

    fun onResume() {
        service.getUserList().enqueue(object : Callback<List<UserVO>> {
            override fun onFailure(call: Call<List<UserVO>>, t: Throwable) {
                Log.e("IOException","===>getUserList() 요청 실패 서버 확인 바람")
                println(t.printStackTrace())
                call.cancel()
            }

            override fun onResponse(call: Call<List<UserVO>>, response: Response<List<UserVO>>) {
                for(data in arrayOf(response.body())) {
                    println(data?.toString())
                }
            }
        })


        service.getUser(1).enqueue(object : Callback<UserVO> {
            override fun onFailure(call: Call<UserVO>, t: Throwable) {
                Log.e("IOException","===>getUserList() 요청 실패 서버 확인 바람")
                println(t.printStackTrace())
                call.cancel()
            }

            override fun onResponse(call: Call<UserVO>, response: Response<UserVO>) {
                println(response?.body().toString())
            }
        })

    }
}