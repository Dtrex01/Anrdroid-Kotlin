package com.example.cakemvvm.di

import android.app.Application
import androidx.room.Room
import com.example.cakemvvm.database.CakeDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    fun providersDatabase(application: Application): CakeDatabase {
return Room.databaseBuilder(application, CakeDatabase::class.java, "cakeshop.database")
    .fallbackToDestructiveMigration()
    .allowMainThreadQueries()
    .build()
    }
    single { providersDatabase(androidApplication())
    }
}