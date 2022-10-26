package com.example.agendakotlin

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.example.agendakotlin.ContactoEntity


@Dao
interface Dao {
    @Query("select * from Usuarios")
    fun getAllContactos(): MutableList<ContactoEntity>


    @Insert
    fun addContacto(contactoEntity: ContactoEntity)



    @Query("UPDATE Usuarios   SET  correo=:correoI ")
    fun updateUsuario(correoI: String)



    @Query("SELECT * FROM  Usuarios  WHERE   correo=:correoI and passwordIni=:pass LIMIT 1")
    fun login(correoI: String, pass:String):ContactoEntity


    @Delete
    fun deleteContacto(contactoEntity: ContactoEntity)

    @Insert
    fun addLibro(librosEntity: LibrosEntity)

    @Query("select * from Libros")
    fun getAllLibros(): MutableList<LibrosEntity>

}



