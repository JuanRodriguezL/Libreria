package com.example.agendakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.agendakotlin.databinding.ActivityActualizarLibroAdminBinding

class ActualizarLibroAdmin : AppCompatActivity() {
  lateinit var  aBinding : ActivityActualizarLibroAdminBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        aBinding = ActivityActualizarLibroAdminBinding.inflate(layoutInflater)
        setContentView(aBinding.root)
    }
}