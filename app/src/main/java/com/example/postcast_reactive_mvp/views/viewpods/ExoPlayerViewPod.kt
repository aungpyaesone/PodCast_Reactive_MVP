package com.example.postcast_reactive_mvp.views.viewpods

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import com.example.postcast_reactive_mvp.R
import com.example.shared.extensions.checkTime
import com.example.shared.extensions.load
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerControlView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.custom_layout.view.ivEpisodeTitle
import kotlinx.android.synthetic.main.custom_layout.view.ivPodcast



class ExoPlayerViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : PlayerControlView(context, attrs, defStyleAttr) {

    private var playWhenReady = false
    private var currentWindow = 0
    private lateinit var simpleExoplayer: SimpleExoPlayer
    private var playbackPosition: Long = 0

    private var mDelegate : MideaPlayerViewPod.Delegate? = null
    override fun onFinishInflate() {
        super.onFinishInflate()
        initializePlayer()
    }

    private fun initializePlayer() {
        simpleExoplayer = SimpleExoPlayer.Builder(context).build()
        player = simpleExoplayer
        val uri = Uri.parse(context.getString(R.string.media_url_mp3))
        val mediaSource = buildMediaSource(uri)
        simpleExoplayer.setPlayWhenReady(playWhenReady)
        simpleExoplayer.seekTo(currentWindow, playbackPosition)
        simpleExoplayer.prepare(mediaSource, false, false)

    }

    private fun buildMediaSource(uri: Uri): MediaSource {
        val dataSourceFactory: DataSource.Factory =
            DefaultDataSourceFactory(context, "PodcastExoPlayer")
        return ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(uri)
    }


    private fun releasePlayer() {
        playWhenReady = simpleExoplayer.playWhenReady
        playbackPosition = simpleExoplayer.currentPosition
        currentWindow = simpleExoplayer.currentWindowIndex
        simpleExoplayer.release()
    }

    fun setDelegate(delegate: MideaPlayerViewPod.Delegate){
        this.mDelegate = delegate
    }

    fun setData(title:String,duration:Int,url:String){
        ivEpisodeTitle.text = title
        ivPodcast.load(url)
    }

    fun onPause(){
        if (Util.SDK_INT < 24 || simpleExoplayer == null) {
            initializePlayer()
        }
    }

    fun onStop(){
        if (Util.SDK_INT < 24 || simpleExoplayer == null) {
           releasePlayer()
        }
    }

    fun onStart(){
        if (Util.SDK_INT < 24 || simpleExoplayer == null) {
            initializePlayer()
        }
    }

    fun onResume(){
        if (Util.SDK_INT < 24 || simpleExoplayer == null) {
            initializePlayer()
        }
    }
}