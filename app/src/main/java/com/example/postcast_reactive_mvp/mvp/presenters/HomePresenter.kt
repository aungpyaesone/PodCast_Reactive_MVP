package com.example.postcast_reactive_mvp.mvp.presenters

import android.content.Context
import com.example.postcast_reactive_mvp.data.vos.ItemVO
import com.example.postcast_reactive_mvp.delegates.LatestEpisodeDelegate
import com.example.postcast_reactive_mvp.mvp.views.HomeView
import com.example.postcast_reactive_mvp.views.viewpods.EmptyViewPod
import com.example.postcast_reactive_mvp.views.viewpods.MideaPlayerViewPod
import com.example.shared.mvp.presenters.BasePresenter

interface HomePresenter : BasePresenter<HomeView>,LatestEpisodeDelegate,EmptyViewPod.Delegate,MideaPlayerViewPod.Delegate {
    fun download(context: Context,itemVO: ItemVO)
}