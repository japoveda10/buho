package com.educationalappsdev.buho.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.educationalappsdev.buho.model.IoTDevice
import com.educationalappsdev.buho.model.PrivacyPolicy
import com.educationalappsdev.buho.model.Tip

const val IoT_DEVICES_COLLECTION_NAME = "iotdevices"
const val PRIVACY_POLICIES_COLLECTION_NAME = "privacypolicies"
const val TIPS_COLLECTION_NAME = "tips"

class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    init {
        firebaseFirestore.firestoreSettings = settings
    }

    fun getIoTDevices(callback: Callback<List<IoTDevice>>) {
        firebaseFirestore.collection(IoT_DEVICES_COLLECTION_NAME)
            .orderBy("category")
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(IoTDevice::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }

    fun getPrivacyPolicies(callback: Callback<List<PrivacyPolicy>>) {
        firebaseFirestore.collection(PRIVACY_POLICIES_COLLECTION_NAME)
            .orderBy("category")
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(PrivacyPolicy::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }

    fun getTips(callback: Callback<List<Tip>>) {
        firebaseFirestore.collection(TIPS_COLLECTION_NAME)
            .orderBy("category")
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Tip::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
}