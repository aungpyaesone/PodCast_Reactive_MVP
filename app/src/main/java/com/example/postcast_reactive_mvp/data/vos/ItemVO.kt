package com.example.postcast_reactive_mvp.data.vos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity (tableName = "item")
data class ItemVO(
    @SerializedName("added_at_ms")var added_at_ms: Long,

    @Embedded
    @SerializedName("data")var data: DataVO,

    @PrimaryKey
    @SerializedName("id")var id: Int,
    @SerializedName("notes")var notes: String,
    @SerializedName("type")var type: String
)