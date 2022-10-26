package com.example.agendakotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agendakotlin.databinding.ItemLibrosDisponiblesBinding

class DisponiblesAdapter(
    private var libros: MutableList<LibrosEntity>, var listener: OnClickListener,
) : RecyclerView.Adapter<DisponiblesAdapter.ViewHolder>() {


    lateinit var mContext: Context

    override fun getItemCount(): Int = libros.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val view =
            LayoutInflater.from(mContext).inflate(R.layout.item_libros_disponibles, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val libro = libros.get(position)

        with(holder) {
            setListener(libro)
            binding.textView3.text = libro.nombreLibro
            binding.textView4.text = libro.autor
        }
    }

    fun setLibros(libro: MutableList<LibrosEntity>) {
        this.libros = libro
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemLibrosDisponiblesBinding.bind(view)

        fun setListener(librosEntity: LibrosEntity) {
            binding.root.setOnClickListener {
                listener.onClick(librosEntity)
            }
        }

    }

}