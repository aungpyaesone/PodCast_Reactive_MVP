package com.example.postcast_reactive_mvp.mvp.presenters.presenterImpls

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.postcast_reactive_mvp.data.models.modelImpls.PodCastModelImpl
import com.example.postcast_reactive_mvp.mvp.presenters.HomePresenter
import com.example.postcast_reactive_mvp.mvp.views.HomeView
import com.example.shared.mvp.presenters.AbstractBasePresenter

object HomePresenterImpl : HomePresenter,AbstractBasePresenter<HomeView>() {
    private val mPodcastModel = PodCastModelImpl

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

    override fun onTouchFifteenSec() {
        Log.d("onTouch","15 sec")
    }

    override fun onTouchThirtySec() {
        Log.d("onTouch","30 Sec")
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        getDataFromApiSaveToDb()
        mPodcastModel.getRandomPodcastEpisodeFromDb().observe(
            lifecycleOwner, Observer {
                it?.let {data ->
                    mView?.bindRandomPodCast(data.last())
                }
            }
        )

        mPodcastModel.getPlayListInfoFromDb().observe(
            lifecycleOwner, Observer { itemList ->
                mView?.bindLatestPodCastList(itemList)
            }
        )
    }

    private fun getDataFromApiSaveToDb(){
       mPodcastModel.getRandomPodcastEpisodeFromApiSaveToDb({},onError = {
          mView?.showErrorMessage(error = it)
       })
    }
}