package com.example.postcast_reactive_mvp.delegates

import com.example.postcast_reactive_mvp.data.vos.ItemVO

interface LatestEpisodeDelegate {
    fun onTouchLatestEpisode(itemVO: ItemVO)

    fun onTouchDownload(itemVO: ItemVO)
}