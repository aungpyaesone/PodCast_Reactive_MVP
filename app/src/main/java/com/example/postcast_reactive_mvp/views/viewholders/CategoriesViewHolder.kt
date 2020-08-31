package com.example.postcast_reactive_mvp.views.viewholders

import android.view.View
import com.example.postcast_reactive_mvp.data.vos.CategoryVO
import com.example.postcast_reactive_mvp.data.vos.GenreVO
import com.example.shared.extensions.load
import com.example.shared.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.categories_item_view.view.*
import kotlinx.android.synthetic.main.fragment_search.view.*

class CategoriesViewHolder(itemView:View) : BaseViewHolder<GenreVO>(itemView) {
    override fun bindData(gener: GenreVO) {
        mData = gener
        itemView.tvTitle.text = gener.name
    }
}