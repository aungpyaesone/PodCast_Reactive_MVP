package com.example.postcast_reactive_mvp.mvp.presenters.presenterImpls

import android.util.Log
import com.example.postcast_reactive_mvp.mvp.presenters.DownloadedPresenter
import com.example.postcast_reactive_mvp.mvp.views.DownloadedView
import com.example.shared.mvp.presenters.AbstractBasePresenter

object DownloadedPresenterImpl : DownloadedPresenter,AbstractBasePresenter<DownloadedView>() {
    override fun onUiReady() {
    }

    override fun onTapFindSomethingNew() {
        Log.d("onTouch","something news")
    }

    override fun onTapReload() {
        Log.d("onTouch","reload")
    }
}