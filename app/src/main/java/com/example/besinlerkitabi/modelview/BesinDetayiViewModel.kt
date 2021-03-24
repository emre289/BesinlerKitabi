package com.example.besinlerkitabi.modelview

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.besinlerkitabi.model.Besin

class BesinDetayiViewModel : ViewModel() {

    val besinLivedata= MutableLiveData<Besin>()

    fun roomVerisiniAl(){
        val muz =Besin("Muz","100","200","300","400","www.test.com")
        besinLivedata.value=muz


    }
}