package com.example.postcast_reactive_mvp.mvp.views

import com.example.shared.mvp.views.BaseView

interface SearchView : BaseView {
   fun showCategories(categoriesVO:String)
}