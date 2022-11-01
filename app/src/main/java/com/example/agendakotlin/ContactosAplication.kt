package com.example.agendakotlin

import android.app.Application
import androidx.room.Room

class ContactosAplication:Application() {

    companion object{
        lateinit var dataBase: UsuariosDataBase

    }

    override fun onCreate() {
        super.onCreate()
       dataBase = Room.databaseBuilder(this, UsuariosDataBase::class.java,"Usuarios.db").allowMainThreadQueries().build()
    }

}