package com.example.agendakotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agendakotlin.databinding.ItemPrestadosBinding

class PrestadosAdapter(private var librosPrestados: MutableList<LibrosPrestadosEntity>) :
    RecyclerView.Adapter<PrestadosAdapter.ViewHolder>() {

    lateinit var pContext: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrestadosAdapter.ViewHolder {
        pContext = parent.context
        val view = LayoutInflater.from(pContext).inflate(R.layout.item_prestados, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PrestadosAdapter.ViewHolder, position: Int) {
        val prestados = librosPrestados.get(position)

        with(holder) {
            Glide.with(pContext)
                .load(prestados.urlImagenPrestamo)
                .into(bindingPrestados.imagenLibrorestado)

            bindingPrestados.textView3prestar.setText(prestados.nombrePrestamo)
            bindingPrestados.textView4prestar.setText(prestados.autorPrestamo)
            bindingPrestados.textView2prestar.setText(prestados.fechaPrestamo)

        }
    }

    override fun getItemCount(): Int = librosPrestados.size


    fun setLibrosPrestados(prestados: MutableList<LibrosPrestadosEntity>) {
        this.librosPrestados = prestados
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bindingPrestados = ItemPrestadosBinding.bind(view)

    }
}