package com.example.agendakotlin

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Usuarios")
data class ContactoEntity(
    @PrimaryKey(autoGenerate = true) var idContact: Long = 0,
    var nombreCompleto: String = "",
    var correo: String = "",
    var telefono: Long = 0,
    var passwordIni: String = "",
)


