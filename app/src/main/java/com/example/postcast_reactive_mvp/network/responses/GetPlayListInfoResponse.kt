package com.example.postcast_reactive_mvp.network.responses

import com.example.postcast_reactive_mvp.data.vos.ItemVO
import com.google.gson.annotations.SerializedName

data class GetPlayListInfoResponse(
    @SerializedName("description")var description: String,
    @SerializedName("id")var id: String,
    @SerializedName("image")var image: String,
    @SerializedName("item")var item: List<ItemVO>,
    @SerializedName("last_timestamp_ms")var last_timestamp_ms: Long,
    @SerializedName("listennotes_url")var listennotes_url: String,
    @SerializedName("name")var name: String,
    @SerializedName("thumbnail")var thumbnail: String,
    @SerializedName("total")var total: Int,
    @SerializedName("type")var type: String,
    @SerializedName("visibility")var visibility: String
)