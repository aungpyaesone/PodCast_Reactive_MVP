package com.example.shared.mvp.presenters

import com.example.shared.mvp.views.BaseView

interface BasePresenter<T: BaseView> {
    fun initPresenter(view: T)
}