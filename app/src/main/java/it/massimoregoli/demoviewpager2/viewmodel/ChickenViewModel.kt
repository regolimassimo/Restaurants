package it.massimoregoli.demoviewpager2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData


@Suppress("SpellCheckingInspection")
class ChickenViewModel(application: Application) : AndroidViewModel(application) {
    var list: MutableLiveData<MutableList<String>> = MutableLiveData()

    init {
        list.value = mutableListOf("Lesso", "Fritto",
            "Arrosto", "Pollo al sale")
    }

    fun onClick(position: Int) {
        val x = list.value?.get(position)
        if (x?.startsWith("> ") == true) {
            list.value?.set(position, x.substring(2))
        } else {
            list.value?.set(position, "> $x")
        }
        list.postValue(list.value)
    }

    fun getSize(): Int {
        return list.value?.size!!
    }
}