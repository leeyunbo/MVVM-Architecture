package com.leeyunbo.realmvvmpractice.viewmodel

import android.util.Log
import androidx.lifecycle.Lifecycle
import com.leeyunbo.realmvvmpractice.api.Api
import com.leeyunbo.realmvvmpractice.data.UserVO
import com.leeyunbo.realmvvmpractice.util.RetrofitFactory
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel {
    private val service =
        RetrofitFactory.getRetrofit().create(Api::class.java)

    fun onResume() : Observable<List<UserVO>> {
        return service.getUserList()
            .subscribeOn(Schedulers.io())
    }
}