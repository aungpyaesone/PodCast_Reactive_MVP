package com.example.postcast_reactive_mvp.data.models.modelImpls

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.postcast_reactive_mvp.data.models.BaseModel
import com.example.postcast_reactive_mvp.data.models.PodCastModel
import com.example.postcast_reactive_mvp.data.vos.DataVO
import com.example.postcast_reactive_mvp.data.vos.GenreVO
import com.example.postcast_reactive_mvp.data.vos.ItemVO
import com.example.postcast_reactive_mvp.network.FirebaseApi
import com.example.postcast_reactive_mvp.network.FriebaseRealTimeImpl
import com.example.postcast_reactive_mvp.network.responses.GetDetailResponse
import com.example.postcast_reactive_mvp.network.responses.GetRandomPodcastResponse
import com.example.postcast_reactive_mvp.util.startDownloading

object PodcastModelFirebaseImpl : PodCastModel, BaseModel() {
    private val mRealTimeFirebase : FirebaseApi = FriebaseRealTimeImpl

    override fun getRandomPodcastEpisodeFromApiSaveToDb(
        onSuccess: (GetRandomPodcastResponse) -> Unit,
        onError: (String) -> Unit
    ) {
       mRealTimeFirebase.getRandomPodcast(onSuccess={
           mTheDB.randomPodCastDao().insertPodCast(it)
       },
       onFailure = {
           onError(it)
       })
    }

    override fun getRandomPodcastEpisodeFromDb(): LiveData<List<GetRandomPodcastResponse>> {
            return mTheDB.randomPodCastDao().getAllPodCast()
    }

    override fun getPodcastGenersFromApiSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit) {
        // get categories
        mRealTimeFirebase.getAllCategories(onSuccess = {
            mTheDB.genreDao().insertGenerList(it)
        },onFailure = {
            onError(it)
        })
    }

    override fun getPodcastGenersFromDb(): LiveData<List<GenreVO>> {
        return mTheDB.genreDao().getAllGener()
    }

    override fun getPlayListInfoFromApiSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mRealTimeFirebase.getEpisodeList(onSuccess = {
            mTheDB.playlistDao().insertPlayList(it)
        },onFailure = {
            onError(it)
        })
    }

    override fun getPlayListInfoFromDb(): LiveData<List<ItemVO>> {
       return mTheDB.playlistDao().getAllPlayList()
    }

    override fun getDetailFromApiSaveToDb(
        id: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mRealTimeFirebase.getDetail(id,onSuccess = {
            mTheDB.detailDao().insertDetail(it)
        },onFailure = {
            onError(it)
        })
    }

    override fun getDetailFromDb(id: String): LiveData<GetDetailResponse> {
       return mTheDB.detailDao().getDetailById(id)
    }

    override fun downloadPodcast(context: Context, itemVO: ItemVO): Long {
        return startDownloading(context = context,itemVO = itemVO)
    }

    override fun getAllDownload(): LiveData<List<DataVO>> {
        return mTheDB.downloadDao().getAllDownloadData()
    }

    override fun saveDownloadItem(dataVO: DataVO) {
        mTheDB.downloadDao().insertData(dataVO)
    }
}