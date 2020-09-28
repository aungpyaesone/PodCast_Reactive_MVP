package com.example.postcast_reactive_mvp.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.postcast_reactive_mvp.persistence.PodCastConverter
import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName


@IgnoreExtraProperties
@Entity(tableName = "download_list")
@TypeConverters(PodCastConverter::class)
class DownloadVO(
    @SerializedName("audio") var audio: String? = "",
    @SerializedName("audio_length_sec") var audio_length_sec: Int? = 0,
    @SerializedName("description") var description: String? = "",
    @SerializedName("explicit_content") var explicit_content: Boolean? = true,

    @PrimaryKey
    @SerializedName("id") var id: String = "",
    @SerializedName("image") var image: String? = "",
    @SerializedName("link") var link: String? = "",
    @SerializedName("listennotes_edit_url") var listennotes_edit_url: String? = "",
    @SerializedName("listennotes_url") var listennotes_url: String? = "",
    @SerializedName("maybe_audio_invarid") var maybe_audio_invarid: Boolean? = true,

    @SerializedName("podcast") var podcast: PodcastVO? = null,
    @SerializedName("pub_date_ms") var pub_date_ms: Long? = 0,
    @SerializedName("thumbnail") var thumbnail: String? = "",
    @SerializedName("title") var title: String? = ""
) {
}