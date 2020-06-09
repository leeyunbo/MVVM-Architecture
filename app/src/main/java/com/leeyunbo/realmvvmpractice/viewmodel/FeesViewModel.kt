package com.leeyunbo.realmvvmpractice.viewmodel

import androidx.lifecycle.MutableLiveData
import com.leeyunbo.realmvvmpractice.datamodel.FeesDataModel

class FeesViewModel {
    private val model : FeesDataModel by lazy {
        FeesDataModel()
    }

    val fees : MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }

    fun getResultToFeesCalculator(percent: Int, input: Int){
        fees.value = model.getResultToFeesCalculator(percent, input)
    }

}