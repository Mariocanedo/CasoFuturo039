package com.example.casofuturo039.Modelo.Local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.casofuturo039.Modelo.Local.Entitys.CoursesDetailEntity
import com.example.casofuturo039.Modelo.Local.Entitys.CoursesEntity


@Dao
interface CentroFuturoDao {



    // insertar Listado de Courses
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCourses(listCourses: List<CoursesEntity>)

    // obtener el listaddo los Courses
    @Query("SELECT * FROM courses_lista_table ORDER BY id ASC")
    fun getAllCourses(): LiveData<List<CoursesEntity>>


    // Insertar de 1 Course
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCourseDetail(course: CoursesDetailEntity)

    // seleccionar detalle de Couses

    @Query("SELECT * FROM courses_detail_table WHERE id=:id")
   fun getCourseDetailById(id: String): LiveData<CoursesDetailEntity>



}