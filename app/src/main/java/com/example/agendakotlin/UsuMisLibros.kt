package com.example.agendakotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.agendakotlin.databinding.ActivityUsuMisLibrosBinding

class UsuMisLibros : AppCompatActivity() {
    lateinit var usuBindig:ActivityUsuMisLibrosBinding
    lateinit var prestadoLayout : GridLayoutManager
    lateinit var adapterPrestado: PrestadosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        usuBindig = ActivityUsuMisLibrosBinding.inflate(layoutInflater)
        setContentView(usuBindig.root)
        setupRecicler()
        usuBindig.buttonPrestar.setOnClickListener {
            val intent = Intent(this, UsuLibrosDisponibles::class.java)
            startActivity(intent)
        }
    }
    private fun setupRecicler() {
        adapterPrestado = PrestadosAdapter(mutableListOf())
        prestadoLayout = GridLayoutManager(this, 2)
        getLibrosPrestado()
        usuBindig.reciclerPrestamos.apply {
            setHasFixedSize(true)
            layoutManager = prestadoLayout
            adapter = adapterPrestado
        }
    }

    private fun getLibrosPrestado() {
        val libroPrestados = ContactosAplication.dataBase.contactosDao().getAllLibrosPrestados()
        adapterPrestado.setLibrosPrestados(libroPrestados)
    }

}