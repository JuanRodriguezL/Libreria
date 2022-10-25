package com.example.agendakotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agendakotlin.databinding.ItemContactosBinding

class ContactosAdapter(
    private var contactos: MutableList<ContactoEntity>, private var listener: OnClickListener,
) :
    RecyclerView.Adapter<ContactosAdapter.ViewHolder>() {

    private lateinit var cContex: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        cContex = parent.context
        val view = LayoutInflater.from(cContex).inflate(R.layout.item_contactos, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contacto = contactos.get(position)

        with(holder) {
            setListener(contacto)
   //         binding.textView4.text = contacto.nombre
    //        binding.textView6.text = contacto.apellido
            binding.textView7.text = contacto.telefono.toString()

        }

    }

    override fun getItemCount(): Int = contactos.size
    fun add(contacto: ContactoEntity) {
        contactos.add(contacto)
        notifyDataSetChanged()

    }

    fun  update (contactoEntity: ContactoEntity){
        val index = contactos.indexOf(contactoEntity)
        if (index!=-1){
            contactos.set(index,contactoEntity)
            notifyItemChanged(index)

        }

    }

    fun  delete (contactoEntity: ContactoEntity){
        val index = contactos.indexOf(contactoEntity)
        if (index!=-1){
            contactos.removeAt(index)
            notifyItemRemoved(index)
        }
    }

    fun setContactos (contactos:MutableList<ContactoEntity>){
        this.contactos=contactos
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemContactosBinding.bind(view)

        fun setListener(contactos: ContactoEntity) {

            binding.root.setOnClickListener { (listener.onClick(contactos)) }
            binding.root.setOnLongClickListener { (listener.onDelete(contactos))

            true}

        }
    }
}

