package com.example.agendakotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.agendakotlin.databinding.ActivityUsuMisLibrosBinding

class UsuMisLibros : AppCompatActivity() {
    private lateinit var usuBindig: ActivityUsuMisLibrosBinding
    private lateinit var prestadoLayout: GridLayoutManager
    private lateinit var adapterPrestado: PrestadosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        usuBindig = ActivityUsuMisLibrosBinding.inflate(layoutInflater)
        setContentView(usuBindig.root)

        usuBindig.toolHistorial.backActi.visibility = View.VISIBLE
        usuBindig.toolHistorial.backActi.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        usuBindig.toolHistorial.deplegar.visibility = View.GONE
        setupRecicler()
        usuBindig.buttonPrestar.setOnClickListener {
            val intent = Intent(this, UsuLibrosDisponibles::class.java)
            startActivity(intent)
        }
    }

    private fun setupRecicler() {
        adapterPrestado = PrestadosAdapter(mutableListOf())
        prestadoLayout = GridLayoutManager(this, 1)
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