package com.example.postcast_reactive_mvp.views.viewholders

import android.view.View
import com.example.postcast_reactive_mvp.data.vos.RandomPodcastVO
import com.example.postcast_reactive_mvp.delegates.LatestEpisodeDelegate
import com.example.shared.extensions.load
import com.example.shared.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.latest_podcast_item_view.view.*


class LatestPodCastViewHolder(itemView: View,val mDelegate:LatestEpisodeDelegate) : BaseViewHolder<RandomPodcastVO>(itemView = itemView) {
    override fun bindData(data: RandomPodcastVO) {
        mData = data
        itemView.categoryTitle.text = data.title
        itemView.ivPodcast.load(data.image)
        itemView.tvCategoryTitle.text = data.publisher

    }
    init {
        itemView.ivPodcast.setOnClickListener {
            mDelegate.onTouchLatestEpisode()
        }
    }

}