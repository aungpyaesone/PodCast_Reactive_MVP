package com.example.postcast_reactive_mvp.mvp.views

import com.example.postcast_reactive_mvp.data.vos.CategoryVO
import com.example.shared.mvp.views.BaseView

interface SearchView : BaseView {
   fun showCategories(categoriesVO:List<CategoryVO>)
}