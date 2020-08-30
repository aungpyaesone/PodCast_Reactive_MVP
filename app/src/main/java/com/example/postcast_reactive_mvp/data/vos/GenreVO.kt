package com.example.postcast_reactive_mvp.data.vos

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "gener")
data class GenreVO(
    @SerializedName("id")var id: Int,
    @SerializedName("name")var name: String,
    @SerializedName("parent_id")var parent_id: Int
)