package com.example.postcast_reactive_mvp.data.models

import android.app.DownloadManager
import android.content.Context
import androidx.lifecycle.LiveData
import com.example.postcast_reactive_mvp.data.vos.*
import com.example.postcast_reactive_mvp.network.responses.GetDetailResponse
import com.example.postcast_reactive_mvp.network.responses.GetRandomPodcastResponse


interface PodCastModel {

    // random podcast api
    fun getRandomPodcastEpisodeFromApiSaveToDb(onSuccess:(GetRandomPodcastResponse)->Unit,onError:(String)->Unit)
    fun getRandomPodcastEpisodeFromDb(): LiveData<List<GetRandomPodcastResponse>>

    // Podcast with Geners api
    fun getPodcastGenersFromApiSaveToDb(onSuccess: () -> Unit,onError: (String) -> Unit)
    fun getPodcastGenersFromDb() : LiveData<List<GenreVO>>

    // PlayList with item
    fun getPlayListInfoFromApiSaveToDb(onSuccess: () -> Unit,onError: (String) -> Unit)
    fun getPlayListInfoFromDb() : LiveData<List<ItemVO>>

    // Detail item
    fun getDetailFromApiSaveToDb(id:String,onSuccess: () -> Unit,onError: (String) -> Unit)
    fun getDetailFromDb(id: String) : LiveData<GetDetailResponse>

    // Download Manager
    fun downloadPodcast(context: Context,itemVO: ItemVO) : Long

    // getDownloadFromDb
    fun getAllDownload():LiveData<List<DataVO>>

    // saveDataVOToDb
    fun saveDownloadItem(dataVO: DataVO)




}