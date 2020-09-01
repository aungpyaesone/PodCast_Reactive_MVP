package com.example.postcast_reactive_mvp.persistence

import androidx.room.TypeConverter
import com.example.postcast_reactive_mvp.data.vos.LookingForVO
import com.example.postcast_reactive_mvp.data.vos.PodcastVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PodCastConverter {
    @TypeConverter
    fun toString(dataList: PodcastVO):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toList(ListJsonStr:String): PodcastVO {
        val dataListType = object : TypeToken<PodcastVO>(){}.type
        return Gson().fromJson(ListJsonStr,dataListType)
    }
}