package com.example.postcast_reactive_mvp.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.media_play_back_small.view.*

class MediaPlayerSmallViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private var mDelegate : Delegate? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    fun setData(duration : Int){
        tvStartTime.text = "00:00"
        tvEndTime.text = "45:00"
        progressBar.progress = 0
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