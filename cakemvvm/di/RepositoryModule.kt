package com.example.cakemvvm.di

import com.example.cakemvvm.database.CakeDao
import com.example.cakemvvm.database.CakeDatabase
import com.example.cakemvvm.network.CakeShop_APIServices
import com.example.cakemvvm.repository.CakeRepository
import org.koin.dsl.module

val repositoryModule= module {
    fun provideRepository(api: CakeShop_APIServices, dao: CakeDatabase):CakeRepository{
        return CakeRepository(api, dao)
    }
    single { provideRepository(get(), get ())
    }
}