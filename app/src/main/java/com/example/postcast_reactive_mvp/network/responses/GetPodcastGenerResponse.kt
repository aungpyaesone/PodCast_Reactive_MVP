package com.example.postcast_reactive_mvp.network.responses

import com.example.postcast_reactive_mvp.data.vos.GenreVO
import com.google.gson.annotations.SerializedName

data class GetPodcastGenerResponse(
    @SerializedName("genres") var genres: List<GenreVO>
)