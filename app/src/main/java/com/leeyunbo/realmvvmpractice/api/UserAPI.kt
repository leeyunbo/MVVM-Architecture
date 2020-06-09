package com.leeyunbo.realmvvmpractice.api

import com.leeyunbo.realmvvmpractice.data.UserVO
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.*

interface UserAPI {
    @Headers("Authorization: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NvdW50X2lkIjoiMTM1OTY0MzA1NCIsImF1dGhfaWQiOiIyIiwidG9rZW5fdHlwZSI6IkFjY2Vzc1Rva2VuIiwic2VydmljZV9pZCI6IjQzMDAxMTQ4MSIsIlgtQXBwLVJhdGUtTGltaXQiOiIyMDAwMDoxMCIsIm5iZiI6MTU5MTY3ODQ2NywiZXhwIjoxNjU0NzUwNDY3LCJpYXQiOjE1OTE2Nzg0Njd9.1CSxuG7-TgWeqEOImu7jzaEzFwgPntsKc3k_7V_OJ1Y")
    @GET("users")
    fun getUser(@Query("nickname") nickname: String) : Call<UserVO>

    @Headers("Authorization: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NvdW50X2lkIjoiMTM1OTY0MzA1NCIsImF1dGhfaWQiOiIyIiwidG9rZW5fdHlwZSI6IkFjY2Vzc1Rva2VuIiwic2VydmljZV9pZCI6IjQzMDAxMTQ4MSIsIlgtQXBwLVJhdGUtTGltaXQiOiIyMDAwMDoxMCIsIm5iZiI6MTU5MTY3ODQ2NywiZXhwIjoxNjU0NzUwNDY3LCJpYXQiOjE1OTE2Nzg0Njd9.1CSxuG7-TgWeqEOImu7jzaEzFwgPntsKc3k_7V_OJ1Y")
    @GET("users/{accessid}/maxdivision")
    fun getUserDivision(@Path("accessid") accessId: String) : Call<List<UserVO>>
}