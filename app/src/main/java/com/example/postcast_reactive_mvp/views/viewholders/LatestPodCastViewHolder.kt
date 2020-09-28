package com.example.postcast_reactive_mvp.views.viewholders

import android.app.DownloadManager
import android.content.Context.DOWNLOAD_SERVICE
import android.view.View
import com.example.postcast_reactive_mvp.data.vos.DataVO
import com.example.postcast_reactive_mvp.data.vos.ItemVO
import com.example.postcast_reactive_mvp.data.vos.RandomPodcastVO
import com.example.postcast_reactive_mvp.delegates.LatestEpisodeDelegate
import com.example.shared.extensions.checkTime
import com.example.shared.extensions.load
import com.example.shared.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.latest_podcast_item_view.view.*


class LatestPodCastViewHolder(itemView: View,val mDelegate:LatestEpisodeDelegate) : BaseViewHolder<DataVO>(itemView = itemView) {
    override fun bindData(item: DataVO) {
        mData = item
       // itemView.categoryTitle.text = item.data.title
        item.image?.let { itemView.ivPodcast.load(it) }
        itemView.tvCategoryTitle.text = item.title
        itemView.tvTime.text = item.audio_length_sec?.checkTime()

    }
    init {
        itemView.setOnClickListener {
            mData?.let {
                mDelegate.onTouchLatestEpisode(it)
            }
        }

        itemView.ivDownload.setOnClickListener {
            mData?.let {
                mDelegate.onTouchDownload(it)
            }
        }
    }

}