package com.example.postcast_reactive_mvp.persistence

import androidx.room.TypeConverter
import com.example.postcast_reactive_mvp.data.vos.DataVO
import com.example.postcast_reactive_mvp.data.vos.ExtraVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DataConverter {
    @TypeConverter
    fun toString(dataList: DataVO):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toList(ListJsonStr:String): DataVO {
        val dataListType = object : TypeToken<DataVO>(){}.type
        return Gson().fromJson(ListJsonStr,dataListType)
    }
}