package com.example.postcast_reactive_mvp.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.postcast_reactive_mvp.data.vos.PodcastVO
import com.example.postcast_reactive_mvp.data.vos.RandomPodcastVO
import com.example.postcast_reactive_mvp.network.responses.GetRandomPodcastResponse

@Dao
interface RandomPodCastDao {
    @Query("SELECT * FROM podcast")
    fun getAllPodCast() : LiveData<List<PodcastVO>>

    @Query("SELECT * FROM podcast WHERE id = :podCastId")
    fun getPodCastById(podCastId :Int) : LiveData<PodcastVO>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPodCast(podCastVORandom: PodcastVO?)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPodCastList(podCast: List<PodcastVO>)
}