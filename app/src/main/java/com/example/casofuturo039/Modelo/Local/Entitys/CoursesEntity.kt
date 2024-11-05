package com.example.casofuturo039.Modelo.Local.Entitys

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "courses_lista_table")
 data class CoursesEntity (

    @PrimaryKey
    val id : String,
    val title : String,
     val previewDescription : String,
     val image : String,
     val weeks : Int,
     val start : String

    )