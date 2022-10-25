package com.example.agendakotlin

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Libros")
data class LibrosEntity(
    @PrimaryKey(autoGenerate = true) var idContact: Long = 0,
    var nombreLibro: String = "",
    var autor: String = "",
    var cantidad: String = "",
    var imagen: String = "",
    var descripcion: String = "",
)
