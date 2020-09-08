package com.example.postcast_reactive_mvp.views.viewpods

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.util.Log
import com.example.postcast_reactive_mvp.PodCastApp
import com.example.postcast_reactive_mvp.PodCastApp.Companion.simpleExoplayer
import com.example.postcast_reactive_mvp.util.PlaybackStateListener
import com.google.android.exoplayer2.ui.PlayerControlView
import kotlinx.android.synthetic.main.activity_pod_cast_detail.view.*
import kotlinx.android.synthetic.main.media_play_back_small.view.*

class MediaPlayerSmallViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : PlayerControlView(context, attrs, defStyleAttr) {

    private var mDelegate : Delegate? = null
    private val playbackStateListener = PlaybackStateListener()
    override fun onFinishInflate() {
        super.onFinishInflate()
            initializePlayer()
    }

    fun setData(playUrl :String){
        val uri = Uri.parse(playUrl.split("?").first())
        Log.d("url",playUrl)
        val mediaSource = PodCastApp.buildMediaSource(context, uri)
        simpleExoplayer?.addListener(playbackStateListener)
        simpleExoplayer?.prepare(mediaSource, false, false)
    }

    private fun initializePlayer() {
        small_control_view.player = simpleExoplayer
    }
    fun setDelegate(delegate:Delegate){
        this.mDelegate = delegate
    }
    private fun setUpListener(){
        tvBackward.setOnClickListener {
            mDelegate?.onTouchFifteenSec()
        }
        tvForward.setOnClickListener {
            mDelegate?.onTouchThirtySec()
        }
    }

 interface Delegate{
        fun onTouchFifteenSec()
        fun onTouchThirtySec()
    }
}