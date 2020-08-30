package com.example.postcast_reactive_mvp.views.viewholders

import android.view.View
import com.example.postcast_reactive_mvp.data.vos.CategoryVO
import com.example.shared.extensions.load
import com.example.shared.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.categories_item_view.view.*

class CategoriesViewHolder(itemView:View) : BaseViewHolder<CategoryVO>(itemView) {
    override fun bindData(data: CategoryVO) {
        mData = data
        itemView.ivPodcast.load(data.imgUrl)
    }
}