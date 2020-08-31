package com.example.postcast_reactive_mvp.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.postcast_reactive_mvp.data.vos.GenreVO
import com.example.postcast_reactive_mvp.network.responses.GetDetailResponse

@Dao
interface DetailDao {
    @Query("SELECT * FROM detail")
    fun getAllDetail() : LiveData<List<GetDetailResponse>>

    @Query("SELECT * FROM detail WHERE id = :detailId")
    fun getDetailById(detailId :String) : LiveData<GetDetailResponse>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertDetail(detail: GetDetailResponse)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertDetailList(detailList: List<GetDetailResponse>)
}