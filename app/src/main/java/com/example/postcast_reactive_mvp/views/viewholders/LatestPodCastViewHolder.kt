package com.example.postcast_reactive_mvp.views.viewholders

import android.view.View
import com.example.postcast_reactive_mvp.data.vos.ItemVO
import com.example.postcast_reactive_mvp.data.vos.RandomPodcastVO
import com.example.postcast_reactive_mvp.delegates.LatestEpisodeDelegate
import com.example.shared.extensions.load
import com.example.shared.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.latest_podcast_item_view.view.*


class LatestPodCastViewHolder(itemView: View,val mDelegate:LatestEpisodeDelegate) : BaseViewHolder<ItemVO>(itemView = itemView) {
    override fun bindData(item: ItemVO) {
        mData = item
       // itemView.categoryTitle.text = item.data.title
        itemView.ivPodcast.load(item.data.image)
        itemView.tvCategoryTitle.text = item.data.title
    }
    init {
        itemView.setOnClickListener {
            mData?.let {
                mDelegate.onTouchLatestEpisode(it)
            }

        }
    }

}