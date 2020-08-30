package com.example.postcast_reactive_mvp.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.postcast_reactive_mvp.data.vos.RandomPodcastVO

@Dao
interface RandomPodCastDao {
    @Query("SELECT * FROM podcast")
    fun getAllPodCast() : LiveData<List<RandomPodcastVO>>

    @Query("SELECT * FROM podcast WHERE id = :podCastId")
    fun getPodCastById(podCastId :Int) : LiveData<RandomPodcastVO>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPodCast(podCastVORandom: RandomPodcastVO)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPodCastList(podCast: List<RandomPodcastVO>)
}