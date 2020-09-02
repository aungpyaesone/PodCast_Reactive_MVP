package com.example.postcast_reactive_mvp.receivers

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.postcast_reactive_mvp.data.models.modelImpls.PodCastModelImpl

class DownloadReceiver : BroadcastReceiver() {
    private val mPodcastModel = PodCastModelImpl
    override fun onReceive(context: Context?, intent: Intent?) {
        val receivedID = intent?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1L)
        val mgr = context!!.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        val query =  DownloadManager.Query()
        query.setFilterById(receivedID!!)
        val cur = mgr.query(query)
        val index = cur.getColumnIndex(DownloadManager.COLUMN_STATUS)
        if(cur.moveToFirst()) {
            if(cur.getInt(index) == DownloadManager.STATUS_SUCCESSFUL){
                // do something
              //  mPodcastModel.save

            }
        }
        cur.close();
    }
}