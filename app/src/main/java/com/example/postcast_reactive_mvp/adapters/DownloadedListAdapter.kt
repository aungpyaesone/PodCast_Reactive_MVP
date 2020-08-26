package com.example.postcast_reactive_mvp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.postcast_reactive_mvp.R
import com.example.postcast_reactive_mvp.delegates.DownloadedItemDelegate
import com.example.postcast_reactive_mvp.views.viewholders.DownloadedViewHolder
import com.example.shared.adapters.BaseAdapter
import com.example.shared.viewholders.BaseViewHolder

class DownloadedListAdapter(val mDelegate: DownloadedItemDelegate) : BaseAdapter<BaseViewHolder<String>,String>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<String> {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.downloaed_item_view,parent,false)
        return DownloadedViewHolder(v,mDelegate)
    }
}