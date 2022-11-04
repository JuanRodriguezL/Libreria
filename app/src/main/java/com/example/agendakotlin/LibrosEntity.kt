package com.example.agendakotlin

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Libros")
data class LibrosEntity(
    @PrimaryKey(autoGenerate = true) var idContact: Long = 0,
    var nombreLibro: String = "",
    var autor: String = "",
    var cantidad: String = "",
    var imagen: String = "",
    var descripcion: String = "",
):Parcelable
