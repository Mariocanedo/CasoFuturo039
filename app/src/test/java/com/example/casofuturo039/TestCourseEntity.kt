package com.example.casofuturo039

import com.example.casofuturo039.Modelo.Local.Entitys.CoursesEntity
import org.junit.After
import org.junit.Before
import org.junit.Test


class TestCourseEntity {

// tengo la instancia de Prueba
private lateinit var courseEntity: CoursesEntity



@Before
fun setup(){

    courseEntity = CoursesEntity(
        id = "1",
        title = "Prueba 039",
        previewDescription = "Prueba test",
        image = "image",
        weeks = 3,
        start = "Noviembre 2024"

    )
}


    @After
    fun tearDown(){

    }


    @Test
    fun TestCourseConstructor() {

        assert(courseEntity.id == "1")
        assert(courseEntity.title == "Prueba 039")
        assert(courseEntity.previewDescription == "Prueba test")
        assert(courseEntity.image == "image")
        assert(courseEntity.weeks == 3)
        assert(courseEntity.start == "Noviembre 2024")
    }


}