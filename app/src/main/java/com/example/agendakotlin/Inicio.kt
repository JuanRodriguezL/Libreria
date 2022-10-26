package com.example.agendakotlin

import android.content.Intent
import android.os.Bundle
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.agendakotlin.databinding.ActivityInicioBinding
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class Inicio : AppCompatActivity(), OnClickListener {
    lateinit var inicioBinding: ActivityInicioBinding
    private lateinit var lAdapter: DisponiblesAdapter
    private lateinit var layout: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inicioBinding = ActivityInicioBinding.inflate(layoutInflater)
        setContentView(inicioBinding.root)
        println("inicio")

        setupRecicler()
      inicioBinding.intento.setOnClickListener {
          val intent = Intent(this, RegistrarLibro::class.java)
          startActivity(intent)
      }
    }

    private fun setupRecicler() {
        lAdapter = DisponiblesAdapter(mutableListOf(),this)
        layout = GridLayoutManager(this, 2)
        getLibrosDis()
        inicioBinding.reciclerLibrosDisponibles.apply {
            setHasFixedSize(true)
            layoutManager = layout
            adapter = lAdapter
        }
    }


    private fun getLibrosDis() {
        doAsync {

            val libro = ContactosAplication.dataBase.contactosDao().getAllLibros()
            uiThread {
            lAdapter.setLibros(libro)
            }
        }
    }



    override fun onClick(contactos: ContactoEntity) {
        TODO("Not yet implemented")
    }

    override fun onClick(entity: LibrosEntity) {
        TODO("Not yet implemented")
    }

    override fun onDelete(contactos: ContactoEntity) {
        TODO("Not yet implemented")
    }

}





