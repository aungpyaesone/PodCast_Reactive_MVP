package com.example.postcast_reactive_mvp.network

import com.example.postcast_reactive_mvp.data.vos.*
import com.example.postcast_reactive_mvp.network.responses.GetDetailResponse
import com.example.postcast_reactive_mvp.network.responses.GetPlayListInfoResponse
import com.example.postcast_reactive_mvp.network.responses.GetRandomPodcastResponse

interface FirebaseApi {
    fun getAllCategories(onSuccess:(genrelist:List<GenreVO>) ->Unit,onFailure :(String) ->Unit)
    fun getEpisodeList(onSuccess: (itemList: List<DataVO>) -> Unit,onFailure: (String) -> Unit)

}