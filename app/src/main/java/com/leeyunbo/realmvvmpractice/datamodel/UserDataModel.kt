package com.leeyunbo.realmvvmpractice.datamodel

import com.leeyunbo.realmvvmpractice.api.UserAPI
import com.leeyunbo.realmvvmpractice.data.UserVO
import com.leeyunbo.realmvvmpractice.util.RetrofitFactory
import retrofit2.Call

class UserDataModel {
    private val service =
        RetrofitFactory.getRetrofit().create(UserAPI::class.java)


    fun getUser() : Call<UserVO> {
        return service.getUser()
    }




}