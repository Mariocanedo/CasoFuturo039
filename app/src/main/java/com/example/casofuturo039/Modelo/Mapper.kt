package com.example.casofuturo039.Modelo

import com.example.casofuturo039.Modelo.Local.Entitys.CoursesDetailEntity
import com.example.casofuturo039.Modelo.Local.Entitys.CoursesEntity
import com.example.casofuturo039.Modelo.Remote.FromInternet.CourseDetail
import com.example.casofuturo039.Modelo.Remote.FromInternet.Courses



// lo de internet pobla lo Local o entidades Locales
fun fromInternetCoursesEntity( coursesList: List<Courses>) : List<CoursesEntity>{

    return coursesList.map {
        CoursesEntity(
            id = it.id,
            title = it.title,
            previewDescription = it.previewDescription,
            image = it.image,
            weeks = it.weeks,
            start = it.start
        )
    }

}

// lo de internet pobla lo Local o entidades Locales
fun fromInternetCourseDetailEntity( course: CourseDetail) : CoursesDetailEntity{

  return CoursesDetailEntity(
      id = course.id,
      title = course.title,
      previewDescription = course.previewDescription,
      image = course.image,
      weeks = course.weeks,
      tuition = course.tuition,
      start = course.start,
      minimumSkill = course.minimumSkill,
      scholarshipsAvailable = course.scholarshipAvailable,
      modality = course.modality)

}



