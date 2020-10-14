package com.example.cakemvvm.network

import android.provider.ContactsContract
import com.example.cakemvvm.database.DatabaseCake
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface CakeShop_APIServices {
    @GET(Api_Calls.API_Cake_LIST)
    fun getCakeList(): Deferred<List<DatabaseCake>>
}