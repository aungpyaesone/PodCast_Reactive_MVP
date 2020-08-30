package com.example.postcast_reactive_mvp.mvp.presenters.presenterImpls

import android.util.Log
import com.example.postcast_reactive_mvp.data.models.modelImpls.PodCastModelImpl
import com.example.postcast_reactive_mvp.mvp.presenters.HomePresenter
import com.example.postcast_reactive_mvp.mvp.views.HomeView
import com.example.shared.mvp.presenters.AbstractBasePresenter

object HomePresenterImpl : HomePresenter,AbstractBasePresenter<HomeView>() {
    private val mPodcastModel =
        PodCastModelImpl
    override fun onUiReady() {

    }

    override fun onTouchLatestEpisode() {
        mView?.navigateToDetailActivity()
        Log.d("onTouch","onTouch")
    }

    override fun onTapFindSomethingNew() {
        Log.d("onTouch","something news")
    }

    override fun onTapReload() {
        Log.d("onTouch","reload")
    }
}