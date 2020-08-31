package com.example.postcast_reactive_mvp.network.responses

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.postcast_reactive_mvp.data.vos.RandomPodcastVO
import com.example.postcast_reactive_mvp.persistence.GenreTypeConverter
import com.google.gson.annotations.SerializedName


@Entity (tableName = "random_podcast")

data class GetRandomPodcastResponse(
    @PrimaryKey
    @SerializedName("id")var id: String,
    @SerializedName("audio")var audio: String,
    @SerializedName("audio_length_sec")var audio_length_sec: Int,
    @SerializedName("description")var description: String,
    @SerializedName("explicit_content")var explicit_content: Boolean,
    @SerializedName("image")var image: String,
    @SerializedName("link")var link: String,
    @SerializedName("listennotes_edit_url")var listennotes_edit_url: String,
    @SerializedName("listennotes_url")var listennotes_url: String,
    @SerializedName("maybe_audio_invarid")var maybe_audio_invarid: Boolean,

    @Embedded(prefix = "_RandomPodcast")
    @SerializedName("podcast")var randomPodcast: RandomPodcastVO,

    @SerializedName("pub_date_ms")var pub_date_ms: Long,
    @SerializedName("thumbnail")var thumbnail: String,
    @SerializedName("title")var title: String
)