package com.example.postcast_reactive_mvp.mvp.presenters

import com.example.postcast_reactive_mvp.mvp.views.SearchView
import com.example.shared.mvp.presenters.BasePresenter

interface SearchPresenter : BasePresenter<SearchView> {
    fun onUiReady();
}