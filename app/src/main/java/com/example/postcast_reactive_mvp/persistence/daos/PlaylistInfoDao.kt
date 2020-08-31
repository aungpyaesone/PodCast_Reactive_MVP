package com.example.postcast_reactive_mvp.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.postcast_reactive_mvp.data.vos.ItemVO

@Dao
interface PlaylistInfoDao {
    @Query("SELECT * FROM playlist")
    fun getAllPlayList() : LiveData<List<ItemVO>>

    @Query("SELECT * FROM playlist WHERE id = :playlistId")
    fun getPlaylistById(playlistId :Int) : LiveData<ItemVO>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPlayList(playlistData: ItemVO)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPlayLists(playlist: List<ItemVO>)
}