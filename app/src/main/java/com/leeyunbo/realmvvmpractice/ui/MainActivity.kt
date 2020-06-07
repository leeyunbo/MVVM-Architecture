package com.leeyunbo.realmvvmpractice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.leeyunbo.realmvvmpractice.R
import com.leeyunbo.realmvvmpractice.data.UserVO
import com.leeyunbo.realmvvmpractice.viewmodel.MainViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val viewModel : MainViewModel by lazy {
        MainViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        get_button.setOnClickListener(View.OnClickListener {
            requestUserList()
        })
    }

    fun requestUserList() {
        viewModel.getUserList()

        val userListObserver = Observer<List<UserVO>> { userList ->
            userlist_tv.text = userList.toString()
        }

        viewModel.userList.observe(this, userListObserver)
    }

}
