package com.example.agendakotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.agendakotlin.databinding.ActivityUsuMisLibrosBinding

class UsuMisLibros : AppCompatActivity() {
    lateinit var usuBindig:ActivityUsuMisLibrosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        usuBindig = ActivityUsuMisLibrosBinding.inflate(layoutInflater)
        setContentView(usuBindig.root)

        usuBindig.buttonPrestar.setOnClickListener {
            val intent = Intent(this, UsuLibrosDisponibles::class.java)
            startActivity(intent)
        }
    }

}