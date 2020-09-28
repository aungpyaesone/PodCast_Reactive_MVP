package com.example.postcast_reactive_mvp.data.models.modelImpls

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.postcast_reactive_mvp.data.models.BaseModel
import com.example.postcast_reactive_mvp.data.models.PodCastModel
import com.example.postcast_reactive_mvp.data.vos.*
import com.example.postcast_reactive_mvp.network.FirebaseApi
import com.example.postcast_reactive_mvp.network.FriebaseRealTimeImpl
import com.example.postcast_reactive_mvp.network.responses.GetDetailResponse
import com.example.postcast_reactive_mvp.network.responses.GetRandomPodcastResponse
import com.example.postcast_reactive_mvp.util.startDownloading

object PodcastModelFirebaseImpl : PodCastModel, BaseModel() {
    private val mRealTimeFirebase : FirebaseApi = FriebaseRealTimeImpl

    override fun getRandomPodcastEpisodeFromApiSaveToDb(
        onSuccess: (DataVO) -> Unit,
        onError: (String) -> Unit
    ) {
//       mRealTimeFirebase.getRandomPodcast(onSuccess={
////           it.podcast?.let { it1 ->
////               mTheDB.randomPodCastDao().insertPodCast(it1) }
//           },
//       onFailure = {
//           onError(it)
//       })
    }

    override fun getRandomPodcastEpisodeFromDb(): LiveData<List<DataVO>> {
            return mTheDB.playlistDao().getAllPlayList()
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

    override fun getPlayListInfoFromDb(): LiveData<List<DataVO>> {
       return mTheDB.playlistDao().getAllPlayList()
    }

    override fun getDetailFromApiSaveToDb(
        id: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

    }

    override fun getDetailFromDb(id: String): LiveData<DataVO> {
       return mTheDB.detailDao().getDetailById(id)
    }

    override fun downloadPodcast(context: Context, itemVO: DataVO): Long {
        return startDownloading(context = context,itemVO = itemVO)
    }

    override fun getAllDownload(): LiveData<List<DownloadVO>> {
        return mTheDB.downloadDao().getAllDownloadData()
    }

    override fun saveDownloadItem(downloadVO: DownloadVO) {
        mTheDB.downloadDao().insertData(downloadVO)
    }
}