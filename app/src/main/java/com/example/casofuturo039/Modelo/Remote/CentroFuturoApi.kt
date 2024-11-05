package com.example.casofuturo039.Modelo.Remote

import com.example.casofuturo039.Modelo.Remote.FromInternet.CourseDetail
import com.example.casofuturo039.Modelo.Remote.FromInternet.Courses
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CentroFuturoApi {


@GET("courses")
suspend fun  fetchCourseList(): Response<List<Courses>>




    @GET("courses/{id}")
    suspend fun  fetchCourseDetail(@Path("id")id: String) : Response<CourseDetail>


}