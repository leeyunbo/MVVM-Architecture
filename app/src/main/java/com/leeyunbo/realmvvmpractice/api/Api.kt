package com.leeyunbo.realmvvmpractice.api

import com.leeyunbo.realmvvmpractice.data.UserVO
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Api {
    @GET("users")
    fun getUserList() : Call<List<UserVO>>

    @GET("/users/{id}")
    fun getUser(@Path("id") id : Int) : UserVO

    @POST("/users")
    fun insertUser(@Body vo : UserVO)
}