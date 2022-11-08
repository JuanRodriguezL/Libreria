package com.example.agendakotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.agendakotlin.databinding.ActivityUsuLibrosDisponiblesBinding

class UsuLibrosDisponibles : AppCompatActivity(), OnClickListener {

    lateinit var lAdapter: DisponiblesAdapter
    private lateinit var layout: GridLayoutManager
    lateinit var usuLibrosBinding: ActivityUsuLibrosDisponiblesBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        usuLibrosBinding = ActivityUsuLibrosDisponiblesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(usuLibrosBinding.root)
        setupRecicler()
    }

    private fun setupRecicler() {
        lAdapter = DisponiblesAdapter(mutableListOf(), this)
        layout = GridLayoutManager(this, 2)
        getLibrosDis()
        usuLibrosBinding.reciclerLibrosDisponiblesUsu.apply {
            setHasFixedSize(true)
            layoutManager = layout
            adapter = lAdapter
        }
    }

    private fun getLibrosDis() {
        val libro = ContactosAplication.dataBase.contactosDao().getAllLibros()
        lAdapter.setLibros(libro)
    }

    override fun onClick(librosEntity: LibrosEntity) {
        val args = Bundle()
        args.putParcelable("parceableEntity", librosEntity)
        val i = Intent(this, UsuPrestarLibro::class.java)
        i.putExtras(args)
        startActivity(i)
    }

    override fun onDelete(librosEntity: LibrosEntity) {
        TODO("Not yet implemented")
    }
}