package com.example.agendakotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.agendakotlin.databinding.ActivityActualizarLibroBinding
import kotlinx.android.synthetic.main.activity_actualizar_libro.*


class ActualizarLibro : AppCompatActivity() {
    private lateinit var upBinding: ActivityActualizarLibroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        upBinding = ActivityActualizarLibroBinding.inflate(layoutInflater)
        setContentView(upBinding.root)

        upBinding.toolUpdate.deplegar.visibility = View.GONE
        upBinding.toolUpdate.backActi.setOnClickListener {
            val intent = Intent(this, Inicio::class.java)
            startActivity(intent)
        }



        val inf = intent.getParcelableExtra<LibrosEntity>("parceableEntity")

        with(upBinding) {

            textUpdateNombreCLibro.setText(inf?.nombreLibro)
            textViewUpdateAutor.setText(inf?.autor)
            textUpdateCantidad.setText(inf?.cantidad)
            UpdateimagenLibro.setText(inf?.imagen)
            Updatedescripcion.setText(inf?.descripcion)
        }




    upBinding.btUpdateLibro.setOnClickListener {
        inf?.nombreLibro = textUpdateNombreCLibro.text.toString()
        inf?.autor = textViewUpdateAutor.text.toString()
        inf?.cantidad = textUpdateCantidad.text.toString()
        inf?.imagen = UpdateimagenLibro.text.toString()
        inf?.descripcion = Updatedescripcion.text.toString()

        ContactosAplication.dataBase.contactosDao().updateLibro(inf!!)
        val intent = Intent(this, Inicio::class.java)
        startActivity(intent)
    }


    }
}