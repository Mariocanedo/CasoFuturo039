package com.example.casofuturo039.Modelo.Local.Entitys

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "courses_detail_table")
data class CoursesDetailEntity(

    @PrimaryKey
    val id: String,
    val title: String,
    val previewDescription: String,
    val image: String,
    val weeks: Int,
    val tuition: String,
    val minimumSkill: String,
    val scholarshipsAvailable: Boolean,
    val modality: String,
    val start: String
)
