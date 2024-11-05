package com.example.casofuturo039.Modelo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.casofuturo039.Modelo.Local.CentroFuturoDao
import com.example.casofuturo039.Modelo.Local.Entitys.CoursesDetailEntity
import com.example.casofuturo039.Modelo.Remote.RetrofitClient

class CentroFuturoRepository (private val centroFuturoDao: CentroFuturoDao){



    // retofit client internet

    private val networService  = RetrofitClient.retrofitInstance()

   // dao listado

    val coursesLiveData = centroFuturoDao.getAllCourses()


    // un elemento
    val courseDetailLivedata = MutableLiveData<CoursesDetailEntity>()


    // Listadp de cursos
    suspend fun fetchCourses(){

        val service = kotlin.runCatching { networService.fetchCourseList() }

        service.onSuccess {
            when (it.code()){

                in 200..299 -> it.body()?.let {

                    Log.d("Cursos", it.toString())
                    centroFuturoDao.insertAllCourses(fromInternetCoursesEntity(it))

                }
                else -> Log.d("Repo","${it.code()} -${it.errorBody()}")

            }
            service.onFailure {
                Log.d("Error","${it.message}")

            }
        }

    }


    // detalle de un curso


    suspend fun  fechtCourseDetail(id : String) : CoursesDetailEntity?{

        val service = kotlin.runCatching { networService.fetchCourseDetail(id) }


        return service.getOrNull()?.body()?.let { courseDetail ->

              val coursesDetailEntity = fromInternetCourseDetailEntity(courseDetail)

              // inserto los datos
              centroFuturoDao.insertCourseDetail(coursesDetailEntity)
              coursesDetailEntity

          }


    }





}