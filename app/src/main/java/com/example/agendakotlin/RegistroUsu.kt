package com.example.agendakotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.agendakotlin.databinding.ActivityRegistroUsuBinding

class RegistroUsu : AppCompatActivity() {
    lateinit var rBinding: ActivityRegistroUsuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rBinding = ActivityRegistroUsuBinding.inflate(layoutInflater)
        setContentView(rBinding.root)

        insertUsuario()


    }

    fun insertUsuario() {
        rBinding.crear.setOnClickListener {
            if (!rBinding.textViewNombreCompleto.text.isNullOrEmpty() && !rBinding.textViewCorreoR.text.isNullOrEmpty() &&
                !rBinding.textTelefonoR.text.isNullOrEmpty() && !rBinding.textPass.text.isNullOrEmpty()
            ) {

                val contacto =
                    ContactoEntity(nombreCompleto = rBinding.textViewNombreCompleto.text.toString(),
                        correo = rBinding.textViewCorreoR.text.toString(),
                        telefono = rBinding.textTelefonoR.text.toString().toLong(),
                        passwordIni = rBinding.textPass.text.toString())
                Thread {
                    ContactosAplication.dataBase.contactosDao().addContacto(contacto)

                }.start()
            }
        }


    }

}