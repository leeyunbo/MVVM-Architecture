package com.leeyunbo.realmvvmpractice.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leeyunbo.realmvvmpractice.data.UserVO
import com.leeyunbo.realmvvmpractice.datamodel.UserDataModel
import kotlinx.coroutines.*

class MainViewModel : ViewModel(){
    private val job = Job()

    private val model : UserDataModel by lazy {
        UserDataModel()
    }
    val userList : MutableLiveData<List<UserVO>> by lazy {
        MutableLiveData<List<UserVO>>()
    }

    fun getUserList() {
        CoroutineScope(Dispatchers.Main).launch {
            print(Thread.currentThread().name)
            val deffered = async(Dispatchers.Default) {
                userList.postValue(model.getUserList())
            }
            deffered.await()
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}