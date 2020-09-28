package com.example.postcast_reactive_mvp.network

import com.example.postcast_reactive_mvp.data.vos.DataVO
import com.example.postcast_reactive_mvp.data.vos.GenreVO
import com.example.postcast_reactive_mvp.data.vos.PodcastDetailVO
import com.example.postcast_reactive_mvp.data.vos.PodcastVO
import com.example.postcast_reactive_mvp.util.EN_ERROR_MESSAGE
import com.example.postcast_reactive_mvp.util.convertToDataVO
import com.example.postcast_reactive_mvp.util.convertToGenreVO
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.getField
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson

object FirebaseFirestoreImpl : FirebaseApi {
    val db = Firebase.firestore
    override fun getAllCategories(
        onSuccess: (genrelist: List<GenreVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("genres")
            .addSnapshotListener { value, error ->
                error?.let { onFailure(it.message ?: EN_ERROR_MESSAGE) }
                    ?: run {
                        val genreList: MutableList<GenreVO> = arrayListOf()
                        val result = value?.documents ?: arrayListOf()

                        for (document in result){
                            val data = document.data.convertToGenreVO()
                            genreList.add(data)
                        }
                    onSuccess(genreList)
                    }
            }
    }

    override fun getEpisodeList(
        onSuccess: (itemList: List<DataVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("latest_episodes")
            .addSnapshotListener{ value, error ->
                error?.let { onFailure(it.message ?: EN_ERROR_MESSAGE) }
                    ?: run{
                        val episodeList : MutableList<DataVO> = arrayListOf()
                        val result = value?.documents ?: arrayListOf()
                        for(document in result){
                            val hashmap = document.data
                            hashmap?.put("id",document.id)
                            val data = Gson().toJson(hashmap)
                            val dataVO = Gson().fromJson<DataVO>(data,DataVO::class.java)
                            episodeList.add(dataVO)
                        }
                        onSuccess(episodeList)
                    }
            }
    }

    override fun getRandomPodcast(
        onSuccess: (randomPodcast: DataVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
    }

    override fun getDetail(
        id: String,
        onSuccess: (detail: List<PodcastDetailVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
    }
}