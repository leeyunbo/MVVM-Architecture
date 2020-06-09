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

    val user : MutableLiveData<UserVO> by lazy {
        MutableLiveData<UserVO>()
    }


    fun getUser(nickname: String) {
        job = GlobalScope.launch(Dispatchers.Main) {
            async(Dispatchers.Default) {
                try {
                    val result = model
                        .getUser()
                        .execute()
                        .body()

                    println(result)

                    user.postValue(result)
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