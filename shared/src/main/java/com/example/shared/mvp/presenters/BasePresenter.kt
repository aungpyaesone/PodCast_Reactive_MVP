package com.example.shared.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.shared.mvp.views.BaseView

interface BasePresenter<T: BaseView> {
    fun initPresenter(view: T)
    fun onUiReady(lifecycleOwner: LifecycleOwner)
}