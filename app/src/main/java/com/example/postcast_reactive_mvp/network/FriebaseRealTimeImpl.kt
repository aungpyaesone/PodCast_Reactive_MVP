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

object FriebaseRealTimeImpl : FirebaseApi {

    val db : DatabaseReference = Firebase.database.reference
    override fun getAllCategories(
        onSuccess: (genrelist: List<GenreVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.child("categories").addValueEventListener(object : ValueEventListener {
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
        onSuccess: (itemList: List<ItemVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.child("playlists").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                onFailure(error.message)
            }
            override fun onDataChange(snapshot: DataSnapshot) {
                val itemList = arrayListOf<ItemVO>()
                for(dataSnapshot: DataSnapshot in snapshot.children){
                        val itemVO = ItemVO()
                        itemVO.id = dataSnapshot.child("id").getValue(Long::class.java)?.toInt()!!
                        itemVO.added_at_ms = dataSnapshot.child("added_at_ms").getValue(Long::class.java)
                        itemVO.notes = dataSnapshot.child("notes").getValue(String::class.java)
                        itemVO.type = dataSnapshot.child("type").getValue(String::class.java)
                        itemVO.data = dataSnapshot.child("data").getValue(DataVO::class.java)
                        itemList.add(itemVO)
                }
                onSuccess(itemList)
            }
        })
    }

    override fun getRandomPodcast(
        onSuccess: (randomPodcast: GetRandomPodcastResponse) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.child("random_podcast").addValueEventListener(object : ValueEventListener
        {
            override fun onCancelled(error: DatabaseError) {
                onFailure(error.message)
            }
            override fun onDataChange(snapshot: DataSnapshot) {
                val randomPodcast = GetRandomPodcastResponse()
                for (dataSnapShot in snapshot.getChildren())  //--> At this point, ds is an iterator of dataSnapshot; it will iterate the dataSnapshot's children. In this case, the first child's type is String, thus the first iteration of ds will have a type of String.
                {
                    randomPodcast.id = dataSnapShot.child("id").getValue(String::class.java)!!
                    randomPodcast.audio = dataSnapShot.child("audio").getValue(String::class.java)
                    randomPodcast.image = dataSnapShot.child("thumbnail").getValue(String::class.java)
                    randomPodcast.title = dataSnapShot.child("title").getValue(String::class.java)
                    randomPodcast.description =
                    dataSnapShot.child("description").getValue(String::class.java)
                }
                onSuccess(randomPodcast)
                }
        })

    }

    override fun getDetail(
        id: String,
        onSuccess: (detail: GetDetailResponse) -> Unit,
        onFailure: (String) -> Unit
    ) {
        Log.d("id",id)
        db.child("details").child(id).addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                onFailure(error.message)
            }
            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.children.forEach{dataSnapshot ->

                        // itemList.add(it)
                        val detail = GetDetailResponse()
                        detail.audio = dataSnapshot.child("audio").getValue(String::class.java)
                        detail.id = dataSnapshot.child("id").getValue(String::class.java)!!
                        detail.audio_length_sec = dataSnapshot.child("audio_length_sec").getValue(Long::class.java)?.toInt()
                        detail.description = dataSnapshot.child("description").getValue(String::class.java)
                        detail.image = dataSnapshot.child("image").getValue(String::class.java)
                        detail.link = dataSnapshot.child("link").getValue(String::class.java)
                        detail.listennotes_edit_url = dataSnapshot.child("listennotes_edit_url").getValue(
                        String::class.java)
                        detail.podcastVO = dataSnapshot.child("podcast").getValue(PodcastVO::class.java)
                        detail.thumbnail = dataSnapshot.child("thumbnail").getValue(String::class.java)
                        detail.title = dataSnapshot.child("title").getValue(String::class.java)

                        onSuccess(detail)

                }

            }
        })
    }

}