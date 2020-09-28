package com.example.postcast_reactive_mvp.data.vos

import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName
@IgnoreExtraProperties
data class ExtraVO(
    @SerializedName("facebook_handle")var facebook_handle: String? ="",
    @SerializedName("google_url")var google_url: String? ="",
    @SerializedName("instagram_handle")var instagram_handle: String? ="",
    @SerializedName("linkedin_url")var linkedin_url: String? = "",
    @SerializedName("patreon_handle")var patreon_handle: String? = "",
    @SerializedName("spotify_url")var spotify_url: String? = "",
    @SerializedName("twitter_handle")var twitter_handle: String? ="",
    @SerializedName("url1")var url1: String? ="",
    @SerializedName("url2")var url2: String? = "",
    @SerializedName("url3")var url3: String? ="",
    @SerializedName("wechat_handle")var wechat_handle: String? = "",
    @SerializedName("youtube_url")var youtube_url: String? =""
)