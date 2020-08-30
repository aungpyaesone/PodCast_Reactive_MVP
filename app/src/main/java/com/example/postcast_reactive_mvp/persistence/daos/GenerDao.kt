package com.example.postcast_reactive_mvp.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.postcast_reactive_mvp.data.vos.GenreVO

@Dao
interface GenerDao {
    @Query("SELECT * FROM gener")
    fun getAllGener() : LiveData<List<GenreVO>>

    @Query("SELECT * FROM gener WHERE id = :generId")
    fun getGenerById(generId :Int) : LiveData<GenreVO>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertGener(genersVO: GenreVO)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertGenerList(news: List<GenreVO>)
}