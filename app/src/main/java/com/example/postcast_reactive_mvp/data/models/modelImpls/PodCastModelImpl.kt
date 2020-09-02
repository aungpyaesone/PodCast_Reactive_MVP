package com.example.postcast_reactive_mvp.data.models.modelImpls

import android.annotation.SuppressLint
import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import androidx.lifecycle.LiveData
import com.example.postcast_reactive_mvp.data.models.BaseModel
import com.example.postcast_reactive_mvp.data.models.PodCastModel
import com.example.postcast_reactive_mvp.data.vos.*
import com.example.postcast_reactive_mvp.network.responses.GetDetailResponse
import com.example.postcast_reactive_mvp.network.responses.GetRandomPodcastResponse
import com.example.postcast_reactive_mvp.util.API_KEY
import com.example.postcast_reactive_mvp.util.EN_ERROR_MESSAGE
import com.example.postcast_reactive_mvp.util.startDownloading
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object PodCastModelImpl : PodCastModel, BaseModel() {
    // get random podcast from network and save to db
    @SuppressLint("CheckResult")
    override fun getRandomPodcastEpisodeFromApiSaveToDb(
        onSuccess: (GetRandomPodcastResponse) -> Unit,
        onError: (String) -> Unit
    ) {
        mClientApi.randomPodcastEpisode(API_KEY)
            .map { it }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let { data ->
                    onSuccess(data)
                    mTheDB.randomPodCastDao().insertPodCast(data)
                }
            }, {
                onError(it.localizedMessage ?: EN_ERROR_MESSAGE)
            })
    }

    //get random podcast from persistence
    override fun getRandomPodcastEpisodeFromDb(): LiveData<List<GetRandomPodcastResponse>> {
        return mTheDB.randomPodCastDao().getAllPodCast()
    }

    // get podcat with gener
    @SuppressLint("CheckResult")
    override fun getPodcastGenersFromApiSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mClientApi.getPodcatGener(API_KEY, "0")
            .map { it.genres.toList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let { data ->
                    mTheDB.genreDao().insertGenerList(data)
                }
            }, {
                onError(it.localizedMessage ?: EN_ERROR_MESSAGE)
            })
    }

    override fun getPodcastGenersFromDb(): LiveData<List<GenreVO>> {
        return mTheDB.genreDao().getAllGener()
    }

    @SuppressLint("CheckResult")
    override fun getPlayListInfoFromApiSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mClientApi.getPodCastPlaylistInfoAndItem(
            API_KEY,
            "SgTozE1ZAe3"
        )
            .map {
                it.item.toList()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let { item ->
                    mTheDB.playlistDao().insertPlayList(item)
                }
            }, {
                onError(it.localizedMessage ?: EN_ERROR_MESSAGE)
            })
    }

    override fun getPlayListInfoFromDb(): LiveData<List<ItemVO>> {
        return mTheDB.playlistDao().getAllPlayList()
    }

    @SuppressLint("CheckResult")
    override fun getDetailFromApiSaveToDb(
        id: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mClientApi.getDetailForEpisode(API_KEY, id)
            .map {
                it
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let { data ->
                    mTheDB.detailDao().insertDetail(data)
                }
            }, {
                onError(it.localizedMessage ?: EN_ERROR_MESSAGE)
            })
    }

    override fun getDetailFromDb(id: String): LiveData<GetDetailResponse> {
        return mTheDB.detailDao().getDetailById(id)
    }

    override fun downloadPodcast(context: Context,
        itemVO: ItemVO) {
     startDownloading(context = context,itemVO = itemVO)
    }

}