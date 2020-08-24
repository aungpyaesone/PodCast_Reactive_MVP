package com.example.postcast_reactive_mvp.mvp.presenters.presenterImpls

import com.example.postcast_reactive_mvp.mvp.presenters.SearchPresenter
import com.example.postcast_reactive_mvp.mvp.views.SearchView
import com.example.shared.mvp.presenters.AbstractBasePresenter

object SearchPresenterImpl : SearchPresenter,AbstractBasePresenter<SearchView>() {
    override fun onUiReady() {

    }
}