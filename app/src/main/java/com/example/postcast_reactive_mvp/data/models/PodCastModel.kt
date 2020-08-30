package com.example.postcast_reactive_mvp.data.models

import androidx.lifecycle.LiveData
import com.example.postcast_reactive_mvp.data.vos.CategoryVO
import com.example.postcast_reactive_mvp.data.vos.GenreVO
import com.example.postcast_reactive_mvp.network.responses.GetRandomPodcastResponse
import com.example.postcast_reactive_mvp.data.vos.ItemVO


interface PodCastModel {

    // random podcast api
    fun getRandomPodcastEpisodeFromApiSaveToDb(onSuccess:()->Unit,onError:(String)->Unit)
    fun getRandomPodcastEpisodeFromDb(): LiveData<GetRandomPodcastResponse>

    // Podcast with Geners api
    fun getPodcastGenersFromApiSaveToDb(onSuccess: () -> Unit,onError: (String) -> Unit)
    fun getPodcastGenersFromDb() : LiveData<List<GenreVO>>

    // PlayList with item
    fun getPlayListInfoFromApiSaveToDb(onSuccess: () -> Unit,onError: (String) -> Unit)
    fun getPlayListInfoFromDb() : LiveData<List<ItemVO>>

    fun getAllCategories(): List<CategoryVO>


}