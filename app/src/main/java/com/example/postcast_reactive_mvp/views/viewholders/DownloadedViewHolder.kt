package com.example.postcast_reactive_mvp.views.viewholders

import android.view.View
import com.example.postcast_reactive_mvp.data.vos.DataVO
import com.example.postcast_reactive_mvp.data.vos.RandomPodcastVO
import com.example.postcast_reactive_mvp.delegates.DownloadedItemDelegate
import com.example.shared.extensions.load
import com.example.shared.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.downloaed_item_view.view.*


class DownloadedViewHolder(itemView:View,val mDelegate:DownloadedItemDelegate) : BaseViewHolder<DataVO>(itemView) {
    override fun bindData(data: DataVO) {
        mData = data
        itemView.tvCategoryTitle.text = data.title
        data.image?.let { itemView.ivPodcast.load(it) }
        itemView.tvDescription.text = data.description

    }

    init {
        itemView.setOnClickListener {
           mData?.let {
               mDelegate.onTouchDownloadedItem(it)
           }
        }
    }
}