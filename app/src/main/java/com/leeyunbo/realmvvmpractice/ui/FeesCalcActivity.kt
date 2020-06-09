package com.leeyunbo.realmvvmpractice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.leeyunbo.realmvvmpractice.R
import com.leeyunbo.realmvvmpractice.data.UserVO
import com.leeyunbo.realmvvmpractice.viewmodel.FeesViewModel
import com.leeyunbo.realmvvmpractice.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_fees_calc.*
import kotlinx.android.synthetic.main.activity_main.*

class FeesCalcActivity : AppCompatActivity() {

    private val viewModel : FeesViewModel by lazy {
        FeesViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fees_calc)

        val feesObserver = Observer<Double> { fees ->
            fees_output_tv.text = fees?.toString()
        }

        viewModel.fees.observe(this, feesObserver)

        fees_none_discount_bt.setOnClickListener {
            getResultToFeesCalculator(0)
        }
        fees_pc_discount_bt.setOnClickListener {
            getResultToFeesCalculator(30)
        }
        fees_top_discount_bt.setOnClickListener {
            getResultToFeesCalculator(20)
        }
        fees_both_discount_bt.setOnClickListener {
            getResultToFeesCalculator(50)
        }

    }

    private fun getResultToFeesCalculator(percent: Int){
        viewModel.getResultToFeesCalculator(percent, fees_input_et.text.toString().toInt())
    }
}