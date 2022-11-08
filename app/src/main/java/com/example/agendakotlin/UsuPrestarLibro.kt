package com.example.agendakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.agendakotlin.databinding.ActivityUsuPrestarLibroBinding

class UsuPrestarLibro : AppCompatActivity() {
    lateinit var  usuPreLibroBinding: ActivityUsuPrestarLibroBinding
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



    }
}