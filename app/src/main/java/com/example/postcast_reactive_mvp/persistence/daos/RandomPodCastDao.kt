package com.example.postcast_reactive_mvp.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.postcast_reactive_mvp.data.vos.RandomPodcastVO
import com.example.postcast_reactive_mvp.network.responses.GetRandomPodcastResponse

@Dao
interface RandomPodCastDao {
    @Query("SELECT * FROM random_podcast")
    fun getAllPodCast() : LiveData<List<GetRandomPodcastResponse>>

    @Query("SELECT * FROM random_podcast WHERE id = :podCastId")
    fun getPodCastById(podCastId :Int) : LiveData<GetRandomPodcastResponse>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPodCast(podCastVORandom: GetRandomPodcastResponse)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPodCastList(podCast: List<GetRandomPodcastResponse>)
}