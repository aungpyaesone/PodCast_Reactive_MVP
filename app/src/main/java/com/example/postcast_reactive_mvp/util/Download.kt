package com.example.postcast_reactive_mvp.util

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.util.Log
import com.example.postcast_reactive_mvp.data.vos.DataVO
import com.example.postcast_reactive_mvp.data.vos.ItemVO

fun startDownloading(context: Context,itemVO: DataVO) : Long {
    val downloadId: Long
   // val uri = Uri.parse(itemVO.data.audio)
    val request = DownloadManager.Request(Uri.parse(itemVO.audio)).apply {
        setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"${itemVO.title?.trim()
            ?.substring(0,8)}.mp3")
        setTitle(itemVO.title)
        setAllowedOverMetered(true)
        setAllowedOverRoaming(true)
    }
    val dManager = context?.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
    downloadId = dManager.enqueue(request)
    return downloadId
    }


