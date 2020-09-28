package com.example.postcast_reactive_mvp.mvp.presenters.presenterImpls

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.postcast_reactive_mvp.data.models.modelImpls.PodCastModelImpl
import com.example.postcast_reactive_mvp.data.models.modelImpls.PodcastModelFirebaseImpl
import com.example.postcast_reactive_mvp.data.vos.DataVO
import com.example.postcast_reactive_mvp.data.vos.DownloadVO
import com.example.postcast_reactive_mvp.data.vos.PodcastVO
import com.example.postcast_reactive_mvp.mvp.presenters.DownloadedPresenter
import com.example.postcast_reactive_mvp.mvp.views.DownloadedView
import com.example.shared.mvp.presenters.AbstractBasePresenter

class DownloadedPresenterImpl : DownloadedPresenter,AbstractBasePresenter<DownloadedView>() {
   // private val mPodcastModel = PodCastModelImpl
    private val mPodcastModel = PodcastModelFirebaseImpl

    override fun onTapFindSomethingNew() {
        Log.d("onTouch","something news")
    }

    override fun onTapReload() {
        Log.d("onTouch","reload")
    }

    override fun onTouchDownloadedItem(downloadVO: DownloadVO) {
        downloadVO.id?.let { mView?.navigateToDetail(it) }
    }


    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        mPodcastModel.getAllDownload().observe(
            lifecycleOwner, Observer {
                it?.let {
                    mView?.showDownloadList(it)
                }
            }
        )
    }


}