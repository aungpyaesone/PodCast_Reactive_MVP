package com.example.postcast_reactive_mvp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.postcast_reactive_mvp.R
import com.example.postcast_reactive_mvp.views.viewholders.CategoriesViewHolder
import com.example.shared.adapters.BaseAdapter
import com.example.shared.viewholders.BaseViewHolder

class CategoriesListAdapter : BaseAdapter<BaseViewHolder<String>,String>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<String> {
       val v = LayoutInflater.from(parent.context).inflate(R.layout.categories_item_view,parent,false)
       return CategoriesViewHolder(v)
    }
}