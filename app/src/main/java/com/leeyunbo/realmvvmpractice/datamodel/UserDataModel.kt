package com.leeyunbo.realmvvmpractice.datamodel

import androidx.annotation.MainThread
import com.leeyunbo.realmvvmpractice.api.Api
import com.leeyunbo.realmvvmpractice.data.UserVO
import com.leeyunbo.realmvvmpractice.util.RetrofitFactory
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class UserDataModel {
    private val service =
        RetrofitFactory.getRetrofit().create(Api::class.java)

    fun getUserList() : Observable<List<UserVO>> {
        return service.getUserList().subscribeOn(Schedulers.io())
    }




}