package com.example.postcast_reactive_mvp.data.vos

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName

@IgnoreExtraProperties
data class RandomPodcastVO(
    @SerializedName("id")var random_id: String ="",
    @SerializedName("image")var image: String? ="",
    @SerializedName("listennotes_url")var listennotes_url: String? = "",
    @SerializedName("publisher")var publisher: String? ="",
    @SerializedName("thumbnail")var thumbnail: String? ="",
    @SerializedName("title")var title: String? = ""
)