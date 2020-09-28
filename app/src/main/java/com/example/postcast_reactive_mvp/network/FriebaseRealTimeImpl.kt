package com.example.postcast_reactive_mvp.network

import com.example.postcast_reactive_mvp.data.vos.*
import com.example.postcast_reactive_mvp.network.responses.GetDetailResponse
import com.example.postcast_reactive_mvp.network.responses.GetRandomPodcastResponse
import com.google.android.exoplayer2.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlin.random.Random
import kotlin.random.nextInt

object FriebaseRealTimeImpl : FirebaseApi {

    val db : DatabaseReference = Firebase.database.reference
    override fun getAllCategories(
        onSuccess: (genrelist: List<GenreVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.child("genres").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                onFailure(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val genreList = arrayListOf<GenreVO>()
                snapshot.children.forEach{dataSnapshot ->
                 dataSnapshot.getValue(GenreVO::class.java)?.let {
                        genreList.add(it)
                    }
                }
                onSuccess(genreList)
            }
        })
    }

    override fun getEpisodeList(
        onSuccess: (itemList: List<DataVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.child("latest_episodes").addValueEventListener(object : ValueEventListener
        {
            override fun onCancelled(error: DatabaseError) {
                onFailure(error.message)
            }
            override fun onDataChange(snapshot: DataSnapshot) {
                val itemList = arrayListOf<DataVO>()
                snapshot.children.forEach{dataSnapshot ->
                    dataSnapshot.getValue(DataVO::class.java)?.let{
                        it.podcast = dataSnapshot.child("podcast").getValue(PodcastVO::class.java)
                        itemList.add(it)
                    }
                }
                onSuccess(itemList)
            }
        })
    }

}