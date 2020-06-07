package com.leeyunbo.realmvvmpractice.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leeyunbo.realmvvmpractice.data.UserVO
import com.leeyunbo.realmvvmpractice.datamodel.UserDataModel
import kotlinx.coroutines.*
import java.io.IOException

class MainViewModel : ViewModel(){
    private var job = Job()

    private val model : UserDataModel by lazy {
        UserDataModel()
    }
    val userList : MutableLiveData<List<UserVO>> by lazy {
        MutableLiveData<List<UserVO>>()
    }

    val user : MutableLiveData<UserVO> by lazy {
        MutableLiveData<UserVO>()
    }

    fun getUserList() {
        job =  GlobalScope.launch(Dispatchers.Main) {
            async(Dispatchers.Default) {
                try {
                    val result = model
                        .getUserList()
                        .execute()
                        .body()

                    if (result!!.isNotEmpty()) {
                        userList.postValue(result)
                    }
                } catch (e : IOException) {
                    e.printStackTrace()
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}