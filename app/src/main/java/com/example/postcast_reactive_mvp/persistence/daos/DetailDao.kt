package com.example.postcast_reactive_mvp.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.postcast_reactive_mvp.data.vos.DataVO
import com.example.postcast_reactive_mvp.data.vos.GenreVO
import com.example.postcast_reactive_mvp.data.vos.PodcastDetailVO
import com.example.postcast_reactive_mvp.network.responses.GetDetailResponse

@Dao
interface DetailDao {
    @Query("SELECT * FROM podcast_data_list")
    fun getAllDetail() : LiveData<List<DataVO>>

    @Query("SELECT * FROM podcast_data_list WHERE id = :detailId")
    fun getDetailById(detailId :String) : LiveData<DataVO>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertDetail(detail: DataVO)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertDetailList(detailList: List<DataVO>)
}