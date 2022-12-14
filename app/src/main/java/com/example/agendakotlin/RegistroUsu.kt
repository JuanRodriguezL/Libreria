package com.example.agendakotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.agendakotlin.databinding.ActivityRegistroUsuBinding

class RegistroUsu : AppCompatActivity() {
    private lateinit var rBinding: ActivityRegistroUsuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rBinding = ActivityRegistroUsuBinding.inflate(layoutInflater)
        setContentView(rBinding.root)

        rBinding.textViewIniciar.setOnClickListener {
            val int = Intent(this, MainActivity::class.java)
            startActivity(int)
        }
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

                    ContactosAplication.dataBase.contactosDao().addContacto(contacto)

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this,
                        "Todos los campos son OBLIGATORIOS",
                        Toast.LENGTH_SHORT)
                        .show()

                    }


        }
    }
}



