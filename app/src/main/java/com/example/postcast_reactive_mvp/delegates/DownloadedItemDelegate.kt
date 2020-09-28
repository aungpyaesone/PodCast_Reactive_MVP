package com.example.postcast_reactive_mvp.delegates

import com.example.postcast_reactive_mvp.data.vos.DataVO
import com.example.postcast_reactive_mvp.data.vos.DownloadVO

interface DownloadedItemDelegate {
    fun onTouchDownloadedItem(dataVO: DownloadVO)
}