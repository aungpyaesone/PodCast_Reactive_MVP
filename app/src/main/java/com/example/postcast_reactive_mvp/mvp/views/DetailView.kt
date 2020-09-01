package com.example.postcast_reactive_mvp.mvp.views

import com.example.postcast_reactive_mvp.data.vos.PodcastVO
import com.example.shared.mvp.views.BaseView

interface DetailView : BaseView {
    fun showDetail(podcastVO: PodcastVO)
}