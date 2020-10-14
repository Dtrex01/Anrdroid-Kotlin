package com.example.cakemvvm.repository

import androidx.lifecycle.LiveData
import com.example.cakemvvm.database.CakeDatabase
import com.example.cakemvvm.database.DatabaseCake
import com.example.cakemvvm.network.CakeShop_APIServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CakeRepository (private val cakeshopApiservices: CakeShop_APIServices,
                      private val database: CakeDatabase)

{
    suspend fun refreshCakes(){
        withContext(Dispatchers.IO){
            val cakeList= cakeshopApiservices.getCakeList().await()
            database.cakeDao.insertAll(cakeList)
        }
    }

    val results: LiveData<List<DatabaseCake>> = database.cakeDao.getLocalDBCakes()
}