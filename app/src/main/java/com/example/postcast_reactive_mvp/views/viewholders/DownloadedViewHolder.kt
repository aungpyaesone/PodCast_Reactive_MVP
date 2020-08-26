package com.example.postcast_reactive_mvp.views.viewholders

import android.view.View
import com.example.postcast_reactive_mvp.delegates.DownloadedItemDelegate
import com.example.shared.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.downloaed_item_view.view.*

class DownloadedViewHolder(itemView:View,val mDelegate:DownloadedItemDelegate) : BaseViewHolder<String>(itemView) {
    override fun bindData(data: String) {
    }

    init {
        itemView.ivPodcast.setOnClickListener {
            mDelegate.onTouchDownloadedItem()
        }
    }
}