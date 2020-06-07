package com.leeyunbo.realmvvmpractice.datamodel

import com.leeyunbo.realmvvmpractice.api.Api
import com.leeyunbo.realmvvmpractice.data.UserVO
import com.leeyunbo.realmvvmpractice.util.RetrofitFactory
import retrofit2.Call

class UserDataModel {
    private val service =
        RetrofitFactory.getRetrofit().create(Api::class.java)

    fun getUserList() : Call<List<UserVO>> {
        return service.getUserList()
    }

    fun getUser(id : Int) : Call<UserVO> {
        return service.getUser(id)
    }




}