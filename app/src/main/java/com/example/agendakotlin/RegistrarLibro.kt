package com.example.agendakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.agendakotlin.databinding.ActivityInicioBinding
import com.example.agendakotlin.databinding.ActivityMainBinding
import com.example.agendakotlin.databinding.ActivityRegistrarLibroBinding

class RegistrarLibro : AppCompatActivity() {
    lateinit var lbinding: ActivityRegistrarLibroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lbinding = ActivityRegistrarLibroBinding.inflate(layoutInflater)
        setContentView(lbinding.root)



        lbinding.btAgregarLibro.setOnClickListener {
            val libros = LibrosEntity(nombreLibro = lbinding.textViewNombreCLibro.text.toString(),
                autor = lbinding.textViewAutor.text.toString(),
                cantidad = lbinding.textCantidad.text.toString(),
                imagen = lbinding.imagenLibro.text.toString(),
                descripcion = lbinding.descripcion.text.toString())

            Thread {
                ContactosAplication.dataBase.contactosDao().addLibro(libros)
            }.start()

        }
    }
}