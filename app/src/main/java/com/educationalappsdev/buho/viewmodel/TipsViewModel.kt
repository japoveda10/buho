package com.educationalappsdev.buho.viewmodel

import androidx.lifecycle.MutableLiveData
import com.educationalappsdev.buho.model.Tip
import com.educationalappsdev.buho.network.Callback
import com.educationalappsdev.buho.network.FirestoreService

class TipsViewModel {
    val firestoreService = FirestoreService()
    var tipsList: MutableLiveData<List<Tip>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getTipsFromFirebase()
    }

    fun getTipsFromFirebase() {
        firestoreService.getTips(object: Callback<List<Tip>> {
            override fun onSuccess(result: List<Tip>?) {
                tipsList.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }

    fun processFinished() {
        isLoading.value = true
    }
}