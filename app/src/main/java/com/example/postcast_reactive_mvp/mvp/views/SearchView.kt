package com.example.postcast_reactive_mvp.mvp.views

import com.example.postcast_reactive_mvp.data.vos.CategoryVO
import com.example.postcast_reactive_mvp.data.vos.GenreVO
import com.example.shared.mvp.views.BaseView

interface SearchView : BaseView {

   fun showGenerList(generList: List<GenreVO>)

   fun bindData(generData: GenreVO)
}