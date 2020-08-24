package com.example.postcast_reactive_mvp.mvp.presenters

import com.example.postcast_reactive_mvp.mvp.views.DownloadedView
import com.example.postcast_reactive_mvp.views.viewpods.EmptyViewPod
import com.example.shared.mvp.presenters.BasePresenter

interface DownloadedPresenter : BasePresenter<DownloadedView>,EmptyViewPod.Delegate{
    fun onUiReady()
}