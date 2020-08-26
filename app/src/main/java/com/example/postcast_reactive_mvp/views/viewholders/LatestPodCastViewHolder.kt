package com.example.postcast_reactive_mvp.views.viewholders

import android.view.View
import com.example.postcast_reactive_mvp.data.vos.PodCastVO
import com.example.postcast_reactive_mvp.delegates.LatestEpisodeDelegate
import com.example.shared.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.activity_pod_cast_detail.view.*
import kotlinx.android.synthetic.main.media_play_back.view.*

class LatestPodCastViewHolder(itemView: View,val mDelegate:LatestEpisodeDelegate) : BaseViewHolder<PodCastVO>(itemView = itemView) {
    override fun bindData(data: PodCastVO) {
        mData = data

    }
    init {
        itemView.ivPodcast.setOnClickListener {
            mDelegate.onTouchLatestEpisode()
        }
    }

}