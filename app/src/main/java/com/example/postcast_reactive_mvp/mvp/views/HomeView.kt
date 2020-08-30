package com.example.postcast_reactive_mvp.mvp.views

import com.example.postcast_reactive_mvp.data.vos.RandomPodcastVO
import com.example.shared.mvp.views.BaseView

interface HomeView : BaseView {
    fun showLatestPodCastList(latestPodCastVORandom: List<RandomPodcastVO>)
    fun navigateToDetailActivity()
}