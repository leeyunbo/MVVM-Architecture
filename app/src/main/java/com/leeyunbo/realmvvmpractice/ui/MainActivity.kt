package com.leeyunbo.realmvvmpractice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.annotations.SerializedName
import com.leeyunbo.realmvvmpractice.R
import com.leeyunbo.realmvvmpractice.data.UserVO
import com.leeyunbo.realmvvmpractice.util.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

class MainActivity : AppCompatActivity() {
    val service =
        RetrofitFactory.getRetrofit().create(RetrofitNetwork::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

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

interface RetrofitNetwork {
    @GET("users")
    fun getUserList() : Call<List<UserVO>>

    @GET("/users/{id}")
    fun getUser(@Path("id") id : Int) : Call<UserVO>

    @POST("/users")
    fun insertUser(@Body vo : UserVO) : Call<UserVO>

}
