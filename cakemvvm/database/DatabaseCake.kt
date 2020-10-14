package com.example.cakemvvm.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class DatabaseCake (
    @PrimaryKey
    var title: String,
    var desc: String,
    var image: String

)

{
}