package com.leeyunbo.realmvvmpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.lang.reflect.Array
import kotlin.Array as Array1
data class UserVO(
    @SerializedName("id")
    var id : Int,
    @SerializedName("nickname")
    var nickname : String
)

class MainActivity : AppCompatActivity() {
    val retrofit =
        Retrofit
            .Builder()
            .baseUrl("http://192.168.219.103:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    val service =
        retrofit.create(RetrofitNetwork::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        /*
        service.getUserList().enqueue(object : Callback<List<UserVO>> {
            override fun onFailure(call: Call<List<UserVO>>, t: Throwable) {
                Log.e("IOException","===>getUserList() 요청 실패 서버 확인 바람")
                println(t.printStackTrace())
                call.cancel()
            }

            override fun onResponse(call: Call<List<UserVO>>, response: Response<Array>) {
                if(response.isSuccessful) {
                    Log.i("Response :: ", response?.body().toString())
                }
            }
        })
        */
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
