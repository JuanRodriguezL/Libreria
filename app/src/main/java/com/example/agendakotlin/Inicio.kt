package com.example.agendakotlin

import android.content.Intent
import android.os.Bundle
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import com.example.agendakotlin.databinding.ActivityInicioBinding

class Inicio : AppCompatActivity() {
    lateinit var inicioBinding: ActivityInicioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inicioBinding = ActivityInicioBinding.inflate(layoutInflater)
        setContentView(inicioBinding.root)


        inicioBinding.tool.opciones.setOnClickListener {
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
                    else -> {false}
                }

            }
            popupMenu.inflate(R.menu.menu)
            popupMenu.show()

        }
    }


}



