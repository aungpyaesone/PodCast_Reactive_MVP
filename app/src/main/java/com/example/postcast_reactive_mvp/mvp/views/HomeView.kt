package com.example.postcast_reactive_mvp.mvp.views

import com.example.shared.mvp.views.BaseView

interface HomeView : BaseView {
    fun showLatestPodCastList(latestPodCastVO: String)
    fun navigateToDetailActivity()
}