package com.leeyunbo.realmvvmpractice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.leeyunbo.realmvvmpractice.R
import com.leeyunbo.realmvvmpractice.viewmodel.MainViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    private val viewModel =
        MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                println(it.toString())
            }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("onSaveInstanceState","=====> onSaveInstanceState() 실행")
    }
}
