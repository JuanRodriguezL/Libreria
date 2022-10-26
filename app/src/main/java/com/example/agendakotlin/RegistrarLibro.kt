package com.example.agendakotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.agendakotlin.databinding.ActivityRegistrarLibroBinding

class RegistrarLibro : AppCompatActivity() {
    lateinit var lbinding: ActivityRegistrarLibroBinding
    lateinit var librosEntity: LibrosEntity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lbinding = ActivityRegistrarLibroBinding.inflate(layoutInflater)
        setContentView(lbinding.root)
        println("register")
/*
        val libros = LibrosEntity(nombreLibro = lbinding.textViewNombreCLibro.text.toString(),
            autor = lbinding.textViewAutor.text.toString(),
            cantidad = lbinding.textCantidad.text.toString(),
            imagen = lbinding.imagenLibro.text.toString(),
            descripcion = lbinding.descripcion.text.toString())*/


        val intent = Intent(this, Inicio::class.java)
        lbinding.btAgregarLibro.setOnClickListener {

            startActivity(intent)


        }
    }

}







