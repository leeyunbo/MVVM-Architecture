package com.leeyunbo.realmvvmpractice.datamodel

import com.leeyunbo.realmvvmpractice.api.Api
import com.leeyunbo.realmvvmpractice.data.UserVO
import com.leeyunbo.realmvvmpractice.util.RetrofitFactory
import okhttp3.Dispatcher

class UserDataModel {
    private val service =
        RetrofitFactory.getRetrofit().create(Api::class.java)

    fun getUserList() : List<UserVO>? {
        return service?.getUserList()
    }




}