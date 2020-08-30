package com.example.postcast_reactive_mvp.views.viewholders

import android.view.View
import com.example.postcast_reactive_mvp.data.vos.RandomPodcastVO
import com.example.postcast_reactive_mvp.delegates.DownloadedItemDelegate
import com.example.shared.extensions.load
import com.example.shared.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.downloaed_item_view.view.categoryTitle
import kotlinx.android.synthetic.main.downloaed_item_view.view.ivPodcast
import kotlinx.android.synthetic.main.downloaed_item_view.view.tvCategoryTitle


class DownloadedViewHolder(itemView:View,val mDelegate:DownloadedItemDelegate) : BaseViewHolder<RandomPodcastVO>(itemView) {
    override fun bindData(data: RandomPodcastVO) {
        mData = data
        itemView.categoryTitle.text = data.title

        itemView.ivPodcast.load(data.image)
        itemView.tvCategoryTitle.text = data.publisher
    }

    init {
        itemView.ivPodcast.setOnClickListener {
            mDelegate.onTouchDownloadedItem()
        }
    }
}