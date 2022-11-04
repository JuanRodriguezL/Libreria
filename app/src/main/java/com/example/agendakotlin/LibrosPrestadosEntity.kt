package com.example.agendakotlin

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Prestamos")
data class LibrosPrestadosEntity(@PrimaryKey(autoGenerate = true) var idPrestamo: Long = 0,
                                 var nombrePrestamo: String = "",
                                 var autorPrestamo: String = "",
                                 var cantidadPrestamo: Long = 0,
                                 var urlImagenPrestamo: String = "",
                                 var fechaPrestamo: String = "",
                                 var share: String = "")
