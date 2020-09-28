package com.example.postcast_reactive_mvp.data.vos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.postcast_reactive_mvp.persistence.ExtraConverter
import com.example.postcast_reactive_mvp.persistence.GenreTypeConverter
import com.example.postcast_reactive_mvp.persistence.LookingForConverter
import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName

@Entity(tableName =  "podcast")
@IgnoreExtraProperties
@TypeConverters(GenreTypeConverter::class,LookingForConverter::class,
ExtraConverter::class)
data class PodcastVO(

    @PrimaryKey
    @SerializedName("id")var id: String ="",
    @SerializedName("image")var image: String? ="",
    @SerializedName("listennotes_url")var listennotes_url: String? = "",
    @SerializedName("publisher")var publisher: String? ="",
    @SerializedName("thumbnail")var thumbnail: String? ="",
    @SerializedName("title")var title: String? = ""
)
// 22 attribute