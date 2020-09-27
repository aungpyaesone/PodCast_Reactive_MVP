package com.example.postcast_reactive_mvp.mvp.presenters.presenterImpls

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.postcast_reactive_mvp.data.models.modelImpls.PodCastModelImpl
import com.example.postcast_reactive_mvp.data.models.modelImpls.PodcastModelFirebaseImpl
import com.example.postcast_reactive_mvp.mvp.presenters.DetailPresenter
import com.example.postcast_reactive_mvp.mvp.views.DetailView
import com.example.shared.mvp.presenters.AbstractBasePresenter

class DetailPresenterImpl : DetailPresenter,AbstractBasePresenter<DetailView>() {
    //private var mModel = PodCastModelImpl
    private var mModel = PodcastModelFirebaseImpl
    private var mPID:String = ""

    init {


    }
    override fun onUiReady(lifecycleOwner: LifecycleOwner, pid: String) {
        requestData(pid)
        mModel.getDetailFromDb(pid).observe(
            lifecycleOwner, Observer {
                it?.let {
                    mView?.showDetail(it)
                }
            }
        )
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {

    }

    override fun onTouchFifteenSec() {
       Log.d("onTouch","on touch")
    }

    override fun onTouchThirtySec() {
        Log.d("onTouch","on touch")
    }

    private fun requestData(pid:String){

        mModel.getDetailFromApiSaveToDb(pid,{},{

            mView?.showErrorMessage(it)
        })
    }
}