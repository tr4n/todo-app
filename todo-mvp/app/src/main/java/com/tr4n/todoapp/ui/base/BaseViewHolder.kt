package com.tr4n.todoapp.ui.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    protected var itemData: T? = null

    init {
        itemView.setOnClickListener {
            itemData?.let(::onHandleItemClick)
        }
    }

    open fun onBindData(itemData: T) {
        this.itemData = itemData
    }

    open fun onHandleItemClick(mainItem: T) {
    }
}
