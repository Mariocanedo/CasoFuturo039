package com.example.casofuturo039

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.casofuturo039.Modelo.CentroFuturoRepository
import com.example.casofuturo039.Modelo.Local.Database.CourseDataBase
import com.example.casofuturo039.Modelo.Local.Entitys.CoursesDetailEntity
import com.example.casofuturo039.Modelo.Local.Entitys.CoursesEntity
import kotlinx.coroutines.launch

class CoursesViewModel (application: Application) : AndroidViewModel(application)

{

    // conexion repository

    private val repository : CentroFuturoRepository

    // entidad

    private val courseDetailLiveData = MutableLiveData<CoursesDetailEntity>()

    private var idSelected : String ="1"

    init {

        val bd = CourseDataBase.getDataBase(application)
        val centroFuturoDao = bd.getCentroFuturoDao()
        repository = CentroFuturoRepository(centroFuturoDao)


        viewModelScope.launch {

            repository.fetchCourses()
        }

    }

    // listado de elementos
    fun getCoursesList() : LiveData<List<CoursesEntity>> = repository.coursesLiveData



    // para obtener un curso por id desde lo que se selecciono

    fun getCourseDetail(): LiveData<CoursesDetailEntity> =courseDetailLiveData



    // esta funciòn se implementa en el second Fragment

    fun getCourseDetailByidFromInternet (id :String) = viewModelScope.launch {


        val courseDetail = repository.fechtCourseDetail(id)
        courseDetail?.let {
            courseDetailLiveData.postValue(it)


        }
    }




}