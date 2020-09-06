package com.example.postcast_reactive_mvp.views.viewholders

import android.view.View
import com.example.postcast_reactive_mvp.data.vos.GenreVO
import com.example.shared.extensions.load
import com.example.shared.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.categories_item_view.view.*

class CategoriesViewHolder(itemView:View) : BaseViewHolder<GenreVO>(itemView) {
    override fun bindData(gener: GenreVO) {
        mData = gener
        itemView.categoryTitle.text = gener.name
        itemView.ivPodcast.load(gener.image_url)
    }
}