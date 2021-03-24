package com.example.besinlerkitabi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.besinlerkitabi.R
import com.example.besinlerkitabi.modelview.BesinDetayiViewModel
import kotlinx.android.synthetic.main.fragment_besin_detayi.*

class BesinDetayiFragment : Fragment() {
    private var besinId=0
    private lateinit var viewModel: BesinDetayiViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_besin_detayi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProviders.of(this).get(BesinDetayiViewModel::class.java) // View Modeli fragmente bağlama
        viewModel.roomVerisiniAl()                                                           // view modeldaki verileri alır

        arguments?.let {
            besinId=BesinDetayiFragmentArgs.fromBundle(it).besinId
            println(besinId)
        }
        observeLiveData()


    }

    fun observeLiveData(){                                                      //Verileri uygulamada gözlemleyez

        viewModel.besinLivedata.observe(viewLifecycleOwner, Observer { besin->
            besin?.let {

                besinIsim.text=it.besinIsim
                besinKalori.text=it.besinKalori
                besinKarbonhidrat.text=it.besinKarbonhidrat
                besinProtein.text=it.besinProtein
                besinYag.text=it.besinYag


            }
        })

    }

}