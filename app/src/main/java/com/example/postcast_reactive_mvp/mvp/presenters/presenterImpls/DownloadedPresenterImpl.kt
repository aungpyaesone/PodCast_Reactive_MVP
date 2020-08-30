package com.example.postcast_reactive_mvp.mvp.presenters.presenterImpls

import android.util.Log
import com.example.postcast_reactive_mvp.data.models.modelImpls.PodCastModelImpl
import com.example.postcast_reactive_mvp.mvp.presenters.DownloadedPresenter
import com.example.postcast_reactive_mvp.mvp.views.DownloadedView
import com.example.shared.mvp.presenters.AbstractBasePresenter

object DownloadedPresenterImpl : DownloadedPresenter,AbstractBasePresenter<DownloadedView>() {
    private val mPodcastModel = PodCastModelImpl
    override fun onUiReady() {
      // mView?.showDownloadedList(mPodcastModel.getAllPodCast())
    }

    override fun onTapFindSomethingNew() {
        Log.d("onTouch","something news")
    }

    override fun onTapReload() {
        Log.d("onTouch","reload")
    }

    override fun onTouchDownloadedItem() {
        mView?.navigateToDetail()
    }
}