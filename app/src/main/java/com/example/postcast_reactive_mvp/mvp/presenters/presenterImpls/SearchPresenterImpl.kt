package com.example.postcast_reactive_mvp.mvp.presenters.presenterImpls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.postcast_reactive_mvp.data.models.modelImpls.PodCastModelImpl
import com.example.postcast_reactive_mvp.mvp.presenters.SearchPresenter
import com.example.postcast_reactive_mvp.mvp.views.SearchView
import com.example.shared.mvp.presenters.AbstractBasePresenter

object SearchPresenterImpl : SearchPresenter,AbstractBasePresenter<SearchView>() {
    private val mPodcastModel = PodCastModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {

        getPodCastGenerFromApiSaveToDb()
        mPodcastModel.getPodcastGenersFromDb().observe(
            lifecycleOwner, Observer {
                it?.let {
                    mView?.showGenerList(it)
                    mView?.bindData(it.first())
                }
            }
        )
    }

    private fun getPodCastGenerFromApiSaveToDb(){
        mPodcastModel.getPodcastGenersFromApiSaveToDb({},{
            mView?.showErrorMessage(it)
        })
    }
}