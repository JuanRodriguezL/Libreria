package com.example.agendakotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.agendakotlin.databinding.ActivityMainBinding
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {
    private lateinit var mbinding: ActivityMainBinding

    private lateinit var layout: GridLayoutManager
    lateinit var contactoEntity: ContactoEntity


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mbinding.root)

        mbinding.registrarse.setOnClickListener {
            val intent = Intent(this, RegistroUsu::class.java)
            startActivity(intent)
        }



        mbinding.iniciarSesion.setOnClickListener {
            val correoSesion = mbinding.textViewCorreoSesion.text.toString().trim()
            val passSesion = mbinding.textPassSesion.text.toString().trim()


            doAsync {
                contactoEntity = ContactosAplication.dataBase.contactosDao().login(correoSesion, passSesion)

                println(ContactosAplication.dataBase.contactosDao().getAllContactos() + "juan"
                )
                uiThread() {
                    if (contactoEntity != null) {
                        val intent = Intent(this@MainActivity, Inicio::class.java)
                        startActivity(intent)


                    }

                }
            }


        }


        /*  mbinding.juan.setOnClickListener {
              val contacto = ContactoEntity(nombre = mbinding.textViewNombre.text.toString().trim(),
                  apellido = mbinding.textapellido.text.toString().trim(),
                  telefono = mbinding.textTelefono.text.toString().toLong())
              Thread {
                  ContactosAplication.dataBase.contactosDao().addContacto(contacto)

              }.start()
              cAdapter.add(contacto)
          }


      //    setupRecicler()
      }

      private fun lauchFragment() {
          val frag = EditFragment()
          val fragMana= supportFragmentManager
          val fragTransa = fragMana.beginTransaction()
          fragTransa.add(R.id.container_main,frag)
          fragTransa.commit()


      }

      private fun getContactos() {
          doAsync {

              val contacto = ContactosAplication.dataBase.contactosDao().getAllContactos()
              uiThread {
                  cAdapter.setContactos(contacto)
              }
          }*/
    }


    /* private fun setupRecicler() {
         cAdapter = ContactosAdapter(mutableListOf(), this)
         layout = GridLayoutManager(this, 2)
         getContactos()
         mbinding.recicler.apply {
             layoutManager = layout
             adapter = cAdapter
         }
     }*/

/*
    override fun onDelete(contactos: ContactoEntity) {
        doAsync {
            ContactosAplication.dataBase.contactosDao().deleteContacto(contactos)
            uiThread {
                cAdapter.delete(contactos)
            }
        }
    }

    override fun onClick(contactos: ContactoEntity) {


    }
*/

}
