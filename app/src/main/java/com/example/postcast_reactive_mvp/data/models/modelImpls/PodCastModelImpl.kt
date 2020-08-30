package com.example.postcast_reactive_mvp.data.models.modelImpls

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.postcast_reactive_mvp.data.models.BaseModel
import com.example.postcast_reactive_mvp.data.models.PodCastModel
import com.example.postcast_reactive_mvp.data.vos.CategoryVO
import com.example.postcast_reactive_mvp.data.vos.GenreVO
import com.example.postcast_reactive_mvp.data.vos.ItemVO
import com.example.postcast_reactive_mvp.network.responses.GetRandomPodcastResponse
import com.example.postcast_reactive_mvp.util.API_KEY
import com.example.postcast_reactive_mvp.util.EN_ERROR_MESSAGE
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object PodCastModelImpl : PodCastModel,BaseModel() {

    // get random podcast from network and save to db
    @SuppressLint("CheckResult")
    override fun getRandomPodcastEpisodeFromApiSaveToDb(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mClientApi.randomPodcastEpisode(API_KEY)
            .map { it }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

            },{
                onError(it.localizedMessage ?: EN_ERROR_MESSAGE)
            })
    }

    //get random podcast from persistence
    override fun getRandomPodcastEpisodeFromDb(): LiveData<GetRandomPodcastResponse> {
        val liveData = MutableLiveData<GetRandomPodcastResponse>()
        return liveData
    }

    // get podcat with gener
    @SuppressLint("CheckResult")
    override fun getPodcastGenersFromApiSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mClientApi.getPodcatGener(API_KEY,"0")
            .map { it.genres.toList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

            },{
                onError(it.localizedMessage ?: EN_ERROR_MESSAGE)
            })
    }

    override fun getPodcastGenersFromDb(): LiveData<List<GenreVO>> {
        TODO("Not yet implemented")
    }

    @SuppressLint("CheckResult")
    override fun getPlayListInfoFromApiSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mClientApi.getPodCastPlaylistInfoAndItem(API_KEY,"SgTozE1ZAe3")
            .map { it.item.toList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

            },{
                onError(it.localizedMessage ?: EN_ERROR_MESSAGE)
            })
    }

    override fun getPlayListInfoFromDb(): LiveData<List<ItemVO>> {
        TODO("Not yet implemented")
    }

    override fun getAllCategories(): List<CategoryVO> {
      //  return getAllCategorie()
        return arrayListOf()
    }
}