package com.example.postcast_reactive_mvp.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.postcast_reactive_mvp.data.vos.*
import com.example.postcast_reactive_mvp.network.responses.GetDetailResponse
import com.example.postcast_reactive_mvp.network.responses.GetRandomPodcastResponse
import com.example.postcast_reactive_mvp.persistence.daos.DetailDao
import com.example.postcast_reactive_mvp.persistence.daos.GenerDao
import com.example.postcast_reactive_mvp.persistence.daos.PlaylistInfoDao
import com.example.postcast_reactive_mvp.persistence.daos.RandomPodCastDao

@Database(entities = [GetRandomPodcastResponse::class,GenreVO::class,
    GetDetailResponse::class,ItemVO::class],version = 1,exportSchema = false)
abstract class PodCastDatabase : RoomDatabase() {
    companion object {
        val DB_NAME = "POD_CAST_DB"
        var dbInstance: PodCastDatabase? = null

        fun getDBInstance(context: Context): PodCastDatabase {
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context, PodCastDatabase::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            val i = dbInstance
            return i!!
        }
    }

    abstract fun genreDao() : GenerDao
    abstract fun randomPodCastDao() : RandomPodCastDao
    abstract fun playlistDao() : PlaylistInfoDao
    abstract fun detailDao() : DetailDao
}