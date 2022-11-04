package com.example.agendakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.agendakotlin.databinding.ActivityUsuMisLibrosBinding

class UsuMisLibros : AppCompatActivity() {
    lateinit var usuBindig:ActivityUsuMisLibrosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        usuBindig = ActivityUsuMisLibrosBinding.inflate(layoutInflater)
        setContentView(usuBindig.root)
    }
}