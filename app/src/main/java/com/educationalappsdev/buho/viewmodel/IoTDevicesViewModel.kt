package com.educationalappsdev.buho.viewmodel

import androidx.lifecycle.MutableLiveData
import com.educationalappsdev.buho.model.IoTDevice
import com.educationalappsdev.buho.network.Callback
import com.educationalappsdev.buho.network.FirestoreService

class IoTDevicesViewModel {
    val firestoreService = FirestoreService()
    var iotDevicesList: MutableLiveData<List<IoTDevice>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getIoTDevicesFromFirebase()
    }

    fun getIoTDevicesFromFirebase() {
        firestoreService.getIoTDevices(object: Callback<List<IoTDevice>> {
            override fun onSuccess(result: List<IoTDevice>?) {
                iotDevicesList.postValue(result)
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