package com.example.postcast_reactive_mvp.mvp.views

import com.example.shared.mvp.views.BaseView

interface DownloadedView : BaseView {

    fun showDownloadedList(downloadedVO: String)
    fun navigateToDetail()
}