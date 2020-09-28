package com.example.postcast_reactive_mvp

import android.app.Application
import android.content.Context
import android.net.Uri
import com.example.postcast_reactive_mvp.data.models.modelImpls.PodCastModelImpl
import com.example.postcast_reactive_mvp.data.models.modelImpls.PodcastModelFirebaseImpl
import com.google.android.exoplayer2.ExoPlayerLibraryInfo
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.util.Util


class PodCastApp : Application() {
    companion object{
        var simpleExoplayer : SimpleExoPlayer? = null
        fun buildMediaSource(context: Context, uri: Uri): MediaSource {

            val httpDataSourceFactory = DefaultHttpDataSourceFactory(
                Util.getUserAgent(context,"PodcastExoPlayer"),
                DefaultHttpDataSource.DEFAULT_CONNECT_TIMEOUT_MILLIS,
                DefaultHttpDataSource.DEFAULT_READ_TIMEOUT_MILLIS,
                true
            )

            val dataSourceFactory: DataSource.Factory =
                DefaultDataSourceFactory(context, httpDataSourceFactory)


            return ProgressiveMediaSource.Factory(dataSourceFactory)
               .createMediaSource(uri)
        }
    }

    override fun onCreate() {
        super.onCreate()
       // PodCastModelImpl.initDatabase(applicationContext)
        PodcastModelFirebaseImpl.initDatabase(applicationContext)

    }



}