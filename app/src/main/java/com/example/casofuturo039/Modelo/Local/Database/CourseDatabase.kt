package com.example.casofuturo039.Modelo.Local.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.casofuturo039.Modelo.Local.CentroFuturoDao
import com.example.casofuturo039.Modelo.Local.Entitys.CoursesDetailEntity
import com.example.casofuturo039.Modelo.Local.Entitys.CoursesEntity


@Database(entities=[CoursesEntity::class, CoursesDetailEntity::class], version = 1,
    exportSchema = false)
abstract class CourseDataBase: RoomDatabase() {

    // REFERENCIA AL DAO PARTE LOCAL
    abstract fun getCentroFuturoDao(): CentroFuturoDao

    companion object {
        @Volatile
        private var INSTANCE: CourseDataBase? = null

        fun getDataBase(context: Context): CourseDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CourseDataBase::class.java,
                    "CASOFUTURO"
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}