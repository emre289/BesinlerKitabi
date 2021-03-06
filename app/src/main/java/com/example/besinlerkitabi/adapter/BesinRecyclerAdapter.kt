package com.example.besinlerkitabi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.besinlerkitabi.R
import com.example.besinlerkitabi.model.Besin
import com.example.besinlerkitabi.util.gorselIndir
import com.example.besinlerkitabi.util.placeholderYap
import com.example.besinlerkitabi.view.BesinListesiFragment
import com.example.besinlerkitabi.view.BesinListesiFragmentDirections
import kotlinx.android.synthetic.main.besin_recycler_row.view.*

class BesinRecyclerAdapter(var besinListesi:ArrayList<Besin>):RecyclerView.Adapter<BesinRecyclerAdapter.BesinViewHolder>() {
    class BesinViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView){



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BesinViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.besin_recycler_row,parent,false)
        return BesinViewHolder(view)

    }

    override fun onBindViewHolder(holder: BesinViewHolder, position: Int) {
        holder.itemView.isim.text=besinListesi.get(position).besinIsim
        holder.itemView.kalori.text=besinListesi.get(position).besinKalori
        //GÖRSEL KISIM EKLENECEK


        holder.itemView.setOnClickListener {
            val action =BesinListesiFragmentDirections.actionBesinListesiFragmentToBesinDetayiFragment2(0)
            Navigation.findNavController(it).navigate(action )
        }
        holder.itemView.imageView.gorselIndir(besinListesi.get(position).besinGorsel, placeholderYap(holder.itemView.context))

    }

    override fun getItemCount(): Int {
        return besinListesi.size
    }
            // GÜNCELLEME İLE YENİ BESİN LİSTESİ GELİRSE BU ŞEKİL YAPIYORUZ

    fun besinlistesiGuncelle(yeniBesinListesi:List<Besin>){
        besinListesi.clear()
        besinListesi.addAll(yeniBesinListesi)
        notifyDataSetChanged()


    }

}