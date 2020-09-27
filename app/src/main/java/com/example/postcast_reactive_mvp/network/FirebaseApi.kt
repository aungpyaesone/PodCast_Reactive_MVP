package com.example.postcast_reactive_mvp.network

import com.example.postcast_reactive_mvp.data.vos.GenreVO
import com.example.postcast_reactive_mvp.data.vos.ItemVO
import com.example.postcast_reactive_mvp.network.responses.GetDetailResponse
import com.example.postcast_reactive_mvp.network.responses.GetPlayListInfoResponse
import com.example.postcast_reactive_mvp.network.responses.GetRandomPodcastResponse

interface FirebaseApi {
    fun getAllCategories(onSuccess:(genrelist:List<GenreVO>) ->Unit,onFailure :(String) ->Unit)
    fun getEpisodeList(onSuccess: (itemList: List<ItemVO>) -> Unit,onFailure: (String) -> Unit)
    fun getRandomPodcast(onSuccess :(randomPodcast: GetRandomPodcastResponse)->Unit, onFailure: (String) -> Unit)
    fun getDetail(id:String,onSuccess:(detail:GetDetailResponse)->Unit,onFailure: (String) -> Unit)
}