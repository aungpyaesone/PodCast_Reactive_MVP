package com.example.postcast_reactive_mvp.mvp.presenters.presenterImpls

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.postcast_reactive_mvp.data.models.modelImpls.PodCastModelImpl
import com.example.postcast_reactive_mvp.data.vos.DataVO
import com.example.postcast_reactive_mvp.mvp.presenters.DownloadedPresenter
import com.example.postcast_reactive_mvp.mvp.views.DownloadedView
import com.example.shared.mvp.presenters.AbstractBasePresenter

class DownloadedPresenterImpl : DownloadedPresenter,AbstractBasePresenter<DownloadedView>() {
    private val mPodcastModel = PodCastModelImpl

    override fun onTapFindSomethingNew() {
        Log.d("onTouch","something news")
    }

    override fun onTapReload() {
        Log.d("onTouch","reload")
    }

    override fun onTouchDownloadedItem(dataVO: DataVO) {
       mView?.navigateToDetail(dataVO.data_id)
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