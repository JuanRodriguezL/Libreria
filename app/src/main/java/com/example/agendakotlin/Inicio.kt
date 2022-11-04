package com.example.agendakotlin

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.agendakotlin.databinding.ActivityInicioBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_registrar_libro.*

class Inicio : AppCompatActivity(), OnClickListener {
    private lateinit var inicioBinding: ActivityInicioBinding
    private lateinit var lAdapter: DisponiblesAdapter
    private lateinit var layout: GridLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inicioBinding = ActivityInicioBinding.inflate(layoutInflater)
        setContentView(inicioBinding.root)


        setupRecicler()
        inicioBinding.tres.setOnClickListener {
            val popupMenu = PopupMenu(this, it)
            popupMenu.setOnMenuItemClickListener { item ->


                when (item.itemId) {
                    R.id.ingreso -> {
                        val intent = Intent(this, RegistrarLibro::class.java)
                        startActivity(intent)
                        true
                    }

                    R.id.salir -> {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        true
                    }

                    /*   R.id.prestados -> {
                        val intent = Intent(this, RegistrarLibro::class.java)
                        startActivity(intent)
                        true
                    }*/

                    else -> false
                }
            }

            popupMenu.inflate(R.menu.menu)
            popupMenu.show()
        }
    }

    private fun setupRecicler() {
        lAdapter = DisponiblesAdapter(mutableListOf(), this)
        layout = GridLayoutManager(this, 2)
        getLibrosDis()
        inicioBinding.reciclerLibrosDisponibles.apply {
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
        val i = Intent(this, ActualizarLibro::class.java)
        i.putExtras(args)
        startActivity(i)

    /*    librosEntity.nombreLibro = "juan"
        librosEntity.autor = "juan"
        librosEntity.cantidad = "12"
        librosEntity.imagen = "juan"
        librosEntity.descripcion = "juan"


            ContactosAplication.dataBase.contactosDao().updateLibro(librosEntity)
        lAdapter.update(librosEntity)*/





     }


    override fun onDelete(librosEntity: LibrosEntity) {
        MaterialAlertDialogBuilder(this)
            .setTitle(R.string.dialog_delete)
            .setPositiveButton(R.string.dialog_confirm,
                DialogInterface.OnClickListener { dialog, which ->
                    ContactosAplication.dataBase.contactosDao().deleteLibro(librosEntity)
                    lAdapter.delete(librosEntity)
                })
            .setNegativeButton(R.string.dialog_cancel, null)
            .show()
    }

}





