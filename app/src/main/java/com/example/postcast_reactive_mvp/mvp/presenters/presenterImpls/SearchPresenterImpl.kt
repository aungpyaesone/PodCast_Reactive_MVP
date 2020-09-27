package com.example.postcast_reactive_mvp.mvp.presenters.presenterImpls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.postcast_reactive_mvp.data.models.modelImpls.PodCastModelImpl
import com.example.postcast_reactive_mvp.data.models.modelImpls.PodcastModelFirebaseImpl
import com.example.postcast_reactive_mvp.mvp.presenters.SearchPresenter
import com.example.postcast_reactive_mvp.mvp.views.SearchView
import com.example.shared.mvp.presenters.AbstractBasePresenter

class SearchPresenterImpl : SearchPresenter,AbstractBasePresenter<SearchView>() {
  //  private val mPodcastModel = PodCastModelImpl
    private val mPodcastModel = PodcastModelFirebaseImpl

    init {
        getPodCastGenerFromApiSaveToDb()
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {

        mPodcastModel.getPodcastGenersFromDb().observe(
            lifecycleOwner, Observer {
                it?.let {
                    mView?.showGenerList(it)
                    if(it.isNotEmpty()) {
                        mView?.bindData(it[0])
                    }
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