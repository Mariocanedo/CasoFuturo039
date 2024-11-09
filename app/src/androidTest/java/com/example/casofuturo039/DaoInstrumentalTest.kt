package com.example.casofuturo039

import androidx.lifecycle.LiveData
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import com.example.casofuturo039.Modelo.Local.CentroFuturoDao
import com.example.casofuturo039.Modelo.Local.Database.CourseDataBase
import com.example.casofuturo039.Modelo.Local.Entitys.CoursesDetailEntity
import com.example.casofuturo039.Modelo.Local.Entitys.CoursesEntity
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.not
import org.hamcrest.MatcherAssert
import org.junit.After
import org.junit.Before
import org.junit.Test

class DaoInstrumentalTest {



    private lateinit var centroFuturoDao: CentroFuturoDao
    private lateinit var db: CourseDataBase


    @Before
    fun setUp(){
        // COnstructor base
        val context = ApplicationProvider.getApplicationContext<android.content.Context>()
        db= Room.inMemoryDatabaseBuilder(context,CourseDataBase::class.java).build()
        centroFuturoDao = db.getCentroFuturoDao()


    }




    @After fun shutDown(){
        db.close()
    }




    @Test
    fun insertCoursesList() = runBlocking {

        val coursesEntity= listOf(
            CoursesEntity ("43","prueba","test1","url",4, "March"),
            CoursesEntity ("44","prueba2","test2","url",4, "March")

        )

        centroFuturoDao.insertAllCourses(coursesEntity)

        val coursesLiveData = centroFuturoDao.getAllCourses()
        val coursesList : List<CoursesEntity> = coursesLiveData.value?: emptyList()

        // verificamos el listado
        // verificamos el listado si no es vacio
        MatcherAssert.assertThat(coursesList, not(emptyList()))
        MatcherAssert.assertThat(coursesList.size,equalTo(2))


    }


    @Test
    fun inserDetailCourse() = runBlocking {



        val courseDetail = CoursesDetailEntity(

            "2",
            "Curso 2",
            "Test2",
            "url",
            4,
            "...",
            "Expert",
            true,
            "remote",
            "ahora"


        )

        centroFuturoDao.insertCourseDetail(courseDetail)

       val courseLiveData =centroFuturoDao.getCourseDetailById("2")
        val courseValue= courseLiveData.value

        MatcherAssert.assertThat(courseValue?.id, equalTo("2"))
        MatcherAssert.assertThat(courseValue?.weeks, equalTo("4"))

    }





}