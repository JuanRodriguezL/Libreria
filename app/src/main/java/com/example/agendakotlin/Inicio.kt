package com.example.agendakotlin

import android.content.Intent
import android.os.Bundle
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.agendakotlin.databinding.ActivityInicioBinding

class Inicio : AppCompatActivity(), OnClickListener {
    private lateinit var inicioBinding: ActivityInicioBinding
    private lateinit var lAdapter: DisponiblesAdapter
    private lateinit var layout: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inicioBinding = ActivityInicioBinding.inflate(layoutInflater)
        setContentView(inicioBinding.root)


        setupRecicler()
        inicioBinding.tres.setOnClickListener {
            val popupMenu = PopupMenu(this, it)
            popupMenu.setOnMenuItemClickListener { item ->


                when (item.itemId) {
                    R.id.ingreso -> {
                        val intent = Intent(this, RegistrarLibro::class.java)
                        startActivity(intent)
                        true
                    }

                    R.id.salir -> {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        true
                    }

                 /*   R.id.prestados -> {
                        val intent = Intent(this, RegistrarLibro::class.java)
                        startActivity(intent)
                        true
                    }*/

                    else -> false
                }
            }

            popupMenu.inflate(R.menu.menu)
            popupMenu.show()
        }
    }

    private fun setupRecicler() {
        lAdapter = DisponiblesAdapter(mutableListOf(), this)
        layout = GridLayoutManager(this, 2)
        getLibrosDis()
        inicioBinding.reciclerLibrosDisponibles.apply {
            setHasFixedSize(true)
            layoutManager = layout
            adapter = lAdapter
        }
    }

    private fun getLibrosDis() {
        val libro = ContactosAplication.dataBase.contactosDao().getAllLibros()
        lAdapter.setLibros(libro)
    }

    override fun onClick(librosEntity: LibrosEntity) {
        TODO("Not yet implemented")
    }


    override fun onDelete(librosEntity: LibrosEntity) {
        ContactosAplication.dataBase.contactosDao().deleteLibro(librosEntity)
        lAdapter.delete(librosEntity)
    }

}





