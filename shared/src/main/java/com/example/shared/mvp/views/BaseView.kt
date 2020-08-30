package com.example.shared.mvp.views

interface BaseView {
    fun showErrorMessage(error: String)
    fun showLoading()
    fun hideLoading()
}