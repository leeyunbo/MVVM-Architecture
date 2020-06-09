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
                    val result : UserVO? = model
                        .getUser(nickname)
                        .execute()
                        .body()

                    println(result.toString())

                    val divisionResult : List<UserVO> = getUserDivision(result!!.accessId)
                    result.matchType = divisionResult[0].matchType
                    result.division = divisionResult[0].division

                    user.postValue(result)
                } catch (e : IOException) {
                    e.printStackTrace()
                }
            }
        }
    }

    fun getUserDivision(accessId: String): List<UserVO> {
        return model.getUserDivision(accessId).execute().body()!!
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}