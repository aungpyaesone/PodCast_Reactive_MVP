package com.example.postcast_reactive_mvp.data.vos

import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.postcast_reactive_mvp.persistence.ExtraConverter
import com.example.postcast_reactive_mvp.persistence.GenreTypeConverter
import com.example.postcast_reactive_mvp.persistence.LookingForConverter
import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName

@IgnoreExtraProperties

@TypeConverters(
    GenreTypeConverter::class, LookingForConverter::class,
    ExtraConverter::class)
class PodcastDetailVO(
    @SerializedName("country") var country: String? ="",
    @SerializedName("description") var description: String? ="",
    @SerializedName("earliest_pub_date_ms") var earliest_pub_date_ms: Long? = 0,
    @SerializedName("email") var email: String? ="",
    @SerializedName("explicit_content") var explicit_content: Boolean? = false,
    @SerializedName("extra") var extra: ExtraVO ? = null,
    @SerializedName("genre_ids") var genre_ids: List<Int>? = arrayListOf(),

    @PrimaryKey
    @SerializedName("id") var id: String ="",
    @SerializedName("image") var image: String? ="",
    @SerializedName("is_claimed") var is_claimed: Boolean? = false,
    @SerializedName("itunes_id") var itunes_id: Int = 0,
    @SerializedName("language") var language: String? ="",
    @SerializedName("latest_pub_date_ms") var latest_pub_date_ms: Long? = 0,
    @SerializedName("listennotes_url") var listennotes_url: String? ="",

    @SerializedName("looking_for") var looking_for: LookingForVO? = null,
    @SerializedName("publisher") var publisher: String? ="",
    @SerializedName("rss") var rss: String? ="",
    @SerializedName("thumbnail") var thumbnail: String? ="",
    @SerializedName("title") var title: String? ="",
    @SerializedName("total_episodes") var total_episodes: Int = 0,
    @SerializedName("type") var type: String? ="",
    @SerializedName("website") var website: String? =""

) {
}