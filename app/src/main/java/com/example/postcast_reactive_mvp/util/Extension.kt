package com.example.postcast_reactive_mvp.util

import com.example.postcast_reactive_mvp.data.vos.DataVO
import com.example.postcast_reactive_mvp.data.vos.DownloadVO


fun DataVO.toDownloadVO(): DownloadVO{
    val mDataVO = DownloadVO()
    mDataVO.id = this.id
    mDataVO.audio = this.audio
    mDataVO.audio_length_sec = this.audio_length_sec
    mDataVO.description = this.description
    mDataVO.image = this.image
    mDataVO.link = this.link
    mDataVO.listennotes_url = this.listennotes_url
    mDataVO.listennotes_edit_url = this.listennotes_edit_url
    mDataVO.maybe_audio_invarid = this.maybe_audio_invarid
    mDataVO.podcast = this.podcast
    mDataVO.title = this.title

    return mDataVO
}