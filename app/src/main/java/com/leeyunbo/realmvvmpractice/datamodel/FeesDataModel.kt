package com.leeyunbo.realmvvmpractice.datamodel

class FeesDataModel {
    fun getResultToFeesCalculator(percent: Int, input: Int) : Double {
        return input * (1 - (percent * 0.01))
    }
}