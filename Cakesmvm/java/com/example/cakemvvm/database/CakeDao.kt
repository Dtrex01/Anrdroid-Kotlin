package com.example.cakemvvm.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.cakemvvm.util.Converters

@Dao
interface CakeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(cakes : List<DatabaseCake>)

    @Query("SELECT * FROM DatabaseCake")
    fun getLocalDBCakes(): LiveData<List<DatabaseCake>>

}
@Database(entities = [DatabaseCake::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class CakeDatabase: RoomDatabase(){
    abstract val cakeDao: CakeDao
}