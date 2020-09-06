package com.example.postcast_reactive_mvp.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.postcast_reactive_mvp.data.vos.DataVO
import io.reactivex.Completable

@Dao
interface DownloadDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertData(dataVO:DataVO)

    @Query("select * from podcast_data")
    fun getAllDownloadData():LiveData<List<DataVO>>
}