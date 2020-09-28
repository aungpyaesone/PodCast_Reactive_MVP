package com.example.postcast_reactive_mvp.mvp.views

import com.example.postcast_reactive_mvp.data.vos.DataVO
import com.example.postcast_reactive_mvp.data.vos.DownloadVO
import com.example.postcast_reactive_mvp.data.vos.PodcastVO
import com.example.shared.mvp.views.BaseView

interface DownloadedView : BaseView {

    fun navigateToDetail(id: String)
    fun showDownloadList(downloadList: List<DownloadVO>)
}