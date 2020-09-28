package com.example.postcast_reactive_mvp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.postcast_reactive_mvp.R
import com.example.postcast_reactive_mvp.data.vos.DataVO
import com.example.postcast_reactive_mvp.data.vos.ItemVO
import com.example.postcast_reactive_mvp.data.vos.RandomPodcastVO
import com.example.postcast_reactive_mvp.delegates.LatestEpisodeDelegate
import com.example.postcast_reactive_mvp.views.viewholders.LatestPodCastViewHolder
import com.example.shared.adapters.BaseAdapter
import com.example.shared.viewholders.BaseViewHolder

class LatestPodCastListAdapter(val mDelegate:LatestEpisodeDelegate) : BaseAdapter<BaseViewHolder<DataVO>,DataVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<DataVO> {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.latest_podcast_item_view,parent,false)
        return LatestPodCastViewHolder(v,mDelegate)
    }
}