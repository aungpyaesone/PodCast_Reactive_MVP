package com.example.postcast_reactive_mvp.util

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.util.Log
import com.example.postcast_reactive_mvp.data.vos.ItemVO

fun startDownloading(context: Context,itemVO: ItemVO) : Long {
    val downloadId: Long
    val uri = Uri.parse(itemVO.data.link.split("?").first())
    val request = DownloadManager.Request(uri).apply {
        setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, uri.lastPathSegment)
        setTitle(itemVO.data.title)
        setAllowedOverMetered(true)
        setAllowedOverRoaming(true)
    }
    val dManager = context?.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
    downloadId = dManager.enqueue(request)
    return downloadId
    }

    /*var dFinish = false
    var progress: Int = 0
    while (!dFinish) {
        val cursor = dManager.query(DownloadManager.Query().setFilterById(downloadId))
        if (cursor.moveToFirst()) {
            val status = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS))
            when (status) {
                DownloadManager.STATUS_FAILED -> {
                    dFinish = true
                }
                DownloadManager.STATUS_RUNNING -> {
                    val total =
                        cursor.getLong(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES))
                    if (total > 0) {
                        val downloaded =
                            cursor.getLong(cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR))
                        progress = ((downloaded * 100L) / total).toInt()
                    }
                }
                DownloadManager.STATUS_SUCCESSFUL -> {
                    progress = 100
                    dFinish = true
                }
            }
        }

    }*/
