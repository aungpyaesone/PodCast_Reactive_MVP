package com.example.postcast_reactive_mvp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.postcast_reactive_mvp.R
import com.example.postcast_reactive_mvp.delegates.LatestEpisodeDelegate
import com.example.postcast_reactive_mvp.views.viewholders.LatestPodCastViewHolder
import com.example.shared.adapters.BaseAdapter
import com.example.shared.viewholders.BaseViewHolder

class LatestPodCastListAdapter(val mDelegate:LatestEpisodeDelegate) : BaseAdapter<BaseViewHolder<String>,String>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<String> {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.latest_podcast_item_view,parent,false)
        return LatestPodCastViewHolder(v,mDelegate)
    }
}