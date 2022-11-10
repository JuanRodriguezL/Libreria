package com.example.agendakotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.agendakotlin.databinding.ActivityRegistrarLibroBinding

class RegistrarLibro : AppCompatActivity() {
   private lateinit var lbinding: ActivityRegistrarLibroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lbinding = ActivityRegistrarLibroBinding.inflate(layoutInflater)
        setContentView(lbinding.root)

        lbinding.toolRegistro.deplegar.visibility = View.GONE
        lbinding.toolRegistro.backActi.setOnClickListener {
            val intent = Intent(this, Inicio::class.java)
            startActivity(intent)
        }


        val intent = Intent(this, Inicio::class.java)
        lbinding.btAgregarLibro.setOnClickListener {
            val libros = LibrosEntity(nombreLibro = lbinding.textViewNombreCLibro.text.toString(),
                autor = lbinding.textViewAutor.text.toString(),
                cantidad = lbinding.textCantidad.text.toString(),
                imagen = lbinding.imagenLibro.text.toString(),
                descripcion = lbinding.descripcion.text.toString())
            ContactosAplication.dataBase.contactosDao().addLibro(libros)
            startActivity(intent)
        }
    }

}







