package com.example.agendakotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.agendakotlin.databinding.ActivityRegistroUsuBinding
import org.jetbrains.anko.toast
import java.util.regex.Matcher
import java.util.regex.Pattern

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




