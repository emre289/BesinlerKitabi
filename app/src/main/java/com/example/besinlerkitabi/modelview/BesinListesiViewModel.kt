package com.example.besinlerkitabi.modelview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.besinlerkitabi.model.Besin
import com.example.besinlerkitabi.servis.BesinAPIServis
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class BesinListesiViewModel : ViewModel(){
    val besinler  = MutableLiveData<List<Besin>>()
    val besinHataMesaji= MutableLiveData<Boolean>() // boolean hata var mmı yok mu ?
    val besinYukleniyor=MutableLiveData<Boolean>()
    private val besinApiServis=BesinAPIServis()
    private val disposable=CompositeDisposable()

    fun refreshData(){
        verileriInternettenAl()

    }
    fun verileriInternettenAl(){
        besinYukleniyor.value=true

        disposable.add(
            besinApiServis.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :DisposableSingleObserver<List<Besin>>(){
                    override fun onSuccess(t: List<Besin>) {
                        //BAŞARILI OLURSA

                        besinler.value=t
                        besinHataMesaji.value=false
                        besinYukleniyor.value=false
                    }

                    override fun onError(e: Throwable) {
                        //HATA ALIRSAK
                        besinHataMesaji.value=true
                        besinYukleniyor.value=false
                        e.printStackTrace()
                    }

                })

        )


    }

}