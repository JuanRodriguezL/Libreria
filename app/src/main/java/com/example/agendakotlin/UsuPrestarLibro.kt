package com.example.agendakotlin

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.example.agendakotlin.databinding.ActivityUsuPrestarLibroBinding


class UsuPrestarLibro : AppCompatActivity() {
    lateinit var  usuPreLibroBinding: ActivityUsuPrestarLibroBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        usuPreLibroBinding = ActivityUsuPrestarLibroBinding.inflate(layoutInflater)
        setContentView(usuPreLibroBinding.root)

        val inf = intent.getParcelableExtra<LibrosEntity>("parceableEntity")


        Glide.with(this)
            .load(inf?.imagen)
            .error(R.drawable.ic_baseline_error)
            .into(usuPreLibroBinding.imageViewPrestarLibro)

        usuPreLibroBinding.textViewPrestarNombre.setText(inf?.nombreLibro)
        usuPreLibroBinding.textViewDescripcionPrestar.setText(inf?.descripcion)


        usuPreLibroBinding.buttonPrestarConfirma.setOnClickListener {

            val prestamos = LibrosPrestadosEntity(
                nombrePrestamo = inf?.nombreLibro.toString(),
                cantidadPrestamo = inf?.cantidad!!.toLong(),
                urlImagenPrestamo = inf.imagen.toString(),
                fechaPrestamo =" dateTime.toString()",
                share = "holi")
            ContactosAplication.dataBase.contactosDao().addPrestamo(prestamos)

            val intent = Intent(this,UsuMisLibros::class.java)
            startActivity(intent)
        }
    }
}