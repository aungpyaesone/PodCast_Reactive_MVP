package com.example.postcast_reactive_mvp.data.vos


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.postcast_reactive_mvp.persistence.DataConverter
import com.example.postcast_reactive_mvp.persistence.PodCastConverter
import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName

@IgnoreExtraProperties
@Entity(tableName = "playlist")
@TypeConverters(DataConverter::class,PodCastConverter::class)
data class ItemVO(
    @PrimaryKey
    @SerializedName("id")var id: Int = 0,
    @SerializedName("added_at_ms")var added_at_ms: Long? = 0,

  //  @Embedded(prefix = "_dataVO")
    @SerializedName("data")var data: DataVO? = null,
    @SerializedName("notes")var notes: String? = "",
    @SerializedName("type")var type: String? = ""
)