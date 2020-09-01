package com.example.postcast_reactive_mvp.mvp.views

import com.example.postcast_reactive_mvp.network.responses.GetDetailResponse
import com.example.shared.mvp.views.BaseView

interface DetailView : BaseView {
    fun showDetail(detailResponse: GetDetailResponse)
}