package com.example.agendakotlin

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [ContactoEntity::class,LibrosEntity::class,LibrosPrestadosEntity::class], version = 1)
abstract class UsuariosDataBase : RoomDatabase() {
    abstract fun  contactosDao (): Dao


}



