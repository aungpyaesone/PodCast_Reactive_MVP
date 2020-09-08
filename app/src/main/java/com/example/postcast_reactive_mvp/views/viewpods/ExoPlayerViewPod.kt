package com.example.postcast_reactive_mvp.views.viewpods

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.util.Log
import com.example.postcast_reactive_mvp.PodCastApp.Companion.buildMediaSource
import com.example.postcast_reactive_mvp.PodCastApp.Companion.simpleExoplayer
import com.example.postcast_reactive_mvp.util.PlaybackStateListener
import com.example.shared.extensions.load
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerControlView
import kotlinx.android.synthetic.main.custom_layout.view.ivEpisodeTitle
import kotlinx.android.synthetic.main.custom_layout.view.ivPodcast
import kotlinx.android.synthetic.main.fragment_home.view.*


class ExoPlayerViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : PlayerControlView(context, attrs, defStyleAttr) {

    private var playWhenReady = false
    private var currentWindow = 0

    private var playbackPosition: Long = 0
    private val playbackStateListener = PlaybackStateListener()

    private var mDelegate : MideaPlayerViewPod.Delegate? = null
    override fun onFinishInflate() {
        super.onFinishInflate()
        initializePlayer()
    }

    private fun initializePlayer() {
      player_control_view.player = simpleExoplayer
    }

    fun releasePlayer() {
        if (simpleExoplayer != null) {
            playWhenReady = simpleExoplayer!!.playWhenReady
            playbackPosition = simpleExoplayer!!.currentPosition
            currentWindow = simpleExoplayer!!.currentWindowIndex
            simpleExoplayer?.removeListener(playbackStateListener)
            simpleExoplayer?.release()
            simpleExoplayer = null
        }
    }

    fun setData(title:String,playUrl:String,url:String){
        ivEpisodeTitle.text = title
        ivPodcast.load(url)
        val uri = Uri.parse(playUrl.split("?").first())
        Log.d("url",playUrl)
        val mediaSource = buildMediaSource(context,uri)
        simpleExoplayer?.playWhenReady = playWhenReady
        simpleExoplayer?.seekTo(currentWindow, playbackPosition)
        simpleExoplayer?.addListener(playbackStateListener)
        simpleExoplayer?.prepare(mediaSource, false, false)
    }
}