package com.example.postcast_reactive_mvp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.postcast_reactive_mvp.mvp.views.DetailView
import com.example.shared.mvp.presenters.BasePresenter

interface DetailPresenter : BasePresenter<DetailView> {
    fun onUiReady(lifecycleOwner: LifecycleOwner,pid:String)
}