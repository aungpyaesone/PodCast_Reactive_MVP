package com.example.postcast_reactive_mvp.delegates

import com.example.postcast_reactive_mvp.data.vos.DataVO

interface DownloadedItemDelegate {
    fun onTouchDownloadedItem(dataVO: DataVO)
}