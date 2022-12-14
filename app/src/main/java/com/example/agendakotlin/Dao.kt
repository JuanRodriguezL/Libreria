package com.example.agendakotlin

import androidx.room.*
import androidx.room.Dao


@Dao
interface Dao {
    @Query("select * from Usuarios")
    fun getAllContactos(): MutableList<ContactoEntity>


    @Insert
    fun addContacto(contactoEntity: ContactoEntity)


    @Query("UPDATE Usuarios   SET  correo=:correoI ")
    fun updateUsuario(correoI: String)



    @Query("SELECT * FROM  Usuarios  WHERE   correo=:correoI and passwordIni=:pass ")
    fun login(correoI: String, pass:String):ContactoEntity


    @Delete
    fun deleteContacto(contactoEntity: ContactoEntity)

    @Insert
    fun addLibro(librosEntity: LibrosEntity)

    @Query("select * from Libros")
    fun getAllLibros(): MutableList<LibrosEntity>

    @Delete
    fun deleteLibro(librosEntity: LibrosEntity)

    @Update
    fun updateLibro( librosEntity: LibrosEntity)

    @Insert
    fun addPrestamo(prestadosEntity: LibrosPrestadosEntity)

    @Query("select * from Prestamos")
    fun getAllLibrosPrestados(): MutableList<LibrosPrestadosEntity>
}



