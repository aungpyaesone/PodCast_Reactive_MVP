package com.example.postcast_reactive_mvp.mvp.views

import com.example.postcast_reactive_mvp.data.vos.ItemVO
import com.example.postcast_reactive_mvp.data.vos.PodcastVO
import com.example.postcast_reactive_mvp.network.responses.GetRandomPodcastResponse
import com.example.shared.mvp.views.BaseView

interface HomeView : BaseView {
    fun bindRandomPodCast(latestPodCastVORandom: GetRandomPodcastResponse)
    fun navigateToDetailActivity(id:String)

    fun bindLatestPodCastList(latestpodCastList: List<ItemVO>)
}