package com.example.postcast_reactive_mvp.network

import com.example.postcast_reactive_mvp.network.responses.GetDetailResponse
import com.example.postcast_reactive_mvp.network.responses.GetPlayListInfoResponse
import com.example.postcast_reactive_mvp.network.responses.GetPodcastGenerResponse
import com.example.postcast_reactive_mvp.network.responses.GetRandomPodcastResponse
import com.example.postcast_reactive_mvp.util.GET_DETAIL_FOR_EPISODE
import com.example.postcast_reactive_mvp.util.GET_PLAYLIST_INFO_AND_ITEM
import com.example.postcast_reactive_mvp.util.GET_PODCAST_GENER
import com.example.postcast_reactive_mvp.util.GET_RANDOM_PODCAST_EPISOE
import io.reactivex.Observable
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ClientApi {

    @GET(GET_RANDOM_PODCAST_EPISOE)
    fun randomPodcastEpisode(@Header("X-ListenAPI-Key") api_key:String):Observable<GetRandomPodcastResponse>

    @FormUrlEncoded
    @GET(GET_PODCAST_GENER)
    fun getPodcatGener(@Header("X-ListenAPI-Key")api_key: String,
    @Path("top_level_only") value:String) : Observable<GetPodcastGenerResponse>

    @GET(GET_PLAYLIST_INFO_AND_ITEM)
    fun getPodCastPlaylistInfoAndItem(@Header("X-ListenAPI-Key")api_key: String,
    @Path("id") id:String) : Observable<GetPlayListInfoResponse>

    @GET(GET_DETAIL_FOR_EPISODE)
    fun getDetailForEpisode(@Header("X-ListenAPI-Key")api_key: String,
    @Path("id")id:String) : Observable<GetDetailResponse>

}