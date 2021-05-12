package it.massimoregoli.demoviewpager2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CommViewModel : ViewModel() {
    val data: MutableLiveData<MutableList<String>> = MutableLiveData()

    fun updateData(list: MutableList<String>) {
        data.value = list
    }
}