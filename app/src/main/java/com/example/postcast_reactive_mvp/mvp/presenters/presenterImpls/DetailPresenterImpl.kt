package com.example.postcast_reactive_mvp.mvp.presenters.presenterImpls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.postcast_reactive_mvp.data.models.modelImpls.PodCastModelImpl
import com.example.postcast_reactive_mvp.mvp.presenters.DetailPresenter
import com.example.postcast_reactive_mvp.mvp.views.DetailView
import com.example.shared.mvp.presenters.AbstractBasePresenter

class DetailPresenterImpl : DetailPresenter,AbstractBasePresenter<DetailView>() {
    private var mModel = PodCastModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner, pid: String) {
        requestData(pid)

        mModel.getDetailFromDb(pid).observe(
            lifecycleOwner, Observer {
                it?.let {
                    mView?.showDetail(it.podcastVO)
                }
            }
        )
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {

    }

    private fun requestData(pid:String){

        mModel.getDetailFromApiSaveToDb(pid,{},{

            mView?.showErrorMessage(it)
        })
    }
}