package com.example.postcast_reactive_mvp.mvp.presenters.presenterImpls

import android.content.Context
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.postcast_reactive_mvp.data.models.modelImpls.PodcastModelFirebaseImpl
import com.example.postcast_reactive_mvp.data.vos.DataVO
import com.example.postcast_reactive_mvp.data.vos.ItemVO
import com.example.postcast_reactive_mvp.mvp.presenters.HomePresenter
import com.example.postcast_reactive_mvp.mvp.views.HomeView
import com.example.shared.mvp.presenters.AbstractBasePresenter
import com.google.gson.Gson

class HomePresenterImpl : HomePresenter,AbstractBasePresenter<HomeView>() {
   // private var mPodcastModel = PodCastModelImpl
    private var mPodcastModel = PodcastModelFirebaseImpl

    init {
        getDataFromApiSaveToDb()
    }

    override fun onTouchLatestEpisode(itemVO: ItemVO) {
        itemVO.data?.id?.let {
            Log.d("Dataid",it)
            mView?.navigateToDetailActivity(it)
            }
      //  Log.d("Dataid","null")

    }

    override fun onTouchDownload(itemVO: ItemVO) {
        Log.d("link",itemVO.data?.audio)
        mView?.checkPermission(itemVO)
    }

    override fun onTapFindSomethingNew() {
        Log.d("onTouch","something news")
    }

    override fun onTapReload() {
        Log.d("onTouch","reload")
        getDataFromApiSaveToDb()
    }

    override fun onTouchFifteenSec() {
        Log.d("onTouch","15 sec")
    }

    override fun onTouchThirtySec() {
        Log.d("onTouch","30 Sec")
    }

    override fun download(context: Context, itemVO: ItemVO):Long{
       return mPodcastModel.downloadPodcast(context,itemVO)
    }

    override fun saveDownload(dataVO: DataVO) {
        mPodcastModel.saveDownloadItem(dataVO)
    }


    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
      //  getDataFromApiSaveToDb()
        mPodcastModel.getRandomPodcastEpisodeFromDb().observe(
            lifecycleOwner, Observer {
                it?.let {data ->
                    if ( data.isNotEmpty()){
                        mView?.bindRandomPodCast(data.last())
                    }

                }
            }
        )

        mPodcastModel.getPlayListInfoFromDb().observe(
            lifecycleOwner, Observer { itemList ->
                itemList?.let {
                    mView?.bindLatestPodCastList(itemList)
                   Log.d("gson",Gson().toJson(it))

                }

            }
        )
    }

    private fun getDataFromApiSaveToDb(){
       mPodcastModel.getRandomPodcastEpisodeFromApiSaveToDb({},onError = {
          mView?.showErrorMessage(error = it)
       })

       mPodcastModel.getPlayListInfoFromApiSaveToDb({},{
           mView?.showErrorMessage(it)
       })
    }


}