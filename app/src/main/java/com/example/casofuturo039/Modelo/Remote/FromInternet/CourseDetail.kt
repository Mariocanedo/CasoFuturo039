package com.example.casofuturo039.Modelo.Remote.FromInternet

data class CourseDetail(
val id: String,
val title: String,
val previewDescription: String,
val image: String,
val weeks: Int,
val tuition: String,
val minimumSkill :String,
//val miniumSkill : String,
val scholarshipAvailable :Boolean,
val modality :String,
val start: String)