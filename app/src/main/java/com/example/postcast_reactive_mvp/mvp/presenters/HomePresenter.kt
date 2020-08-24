package com.example.postcast_reactive_mvp.mvp.presenters

import com.example.postcast_reactive_mvp.delegates.LatestEpisodeDelegate
import com.example.postcast_reactive_mvp.mvp.views.HomeView
import com.example.postcast_reactive_mvp.views.viewpods.EmptyViewPod
import com.example.shared.mvp.presenters.BasePresenter
import com.example.shared.mvp.views.BaseView

interface HomePresenter : BasePresenter<HomeView>,LatestEpisodeDelegate,EmptyViewPod.Delegate {
    fun onUiReady();
}