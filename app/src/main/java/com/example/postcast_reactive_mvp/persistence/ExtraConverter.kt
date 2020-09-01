package com.example.postcast_reactive_mvp.persistence

import androidx.room.TypeConverter
import com.example.postcast_reactive_mvp.data.vos.ExtraVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ExtraConverter {
    @TypeConverter
    fun toString(dataList:ExtraVO):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toList(ListJsonStr:String): ExtraVO{
        val dataListType = object : TypeToken<ExtraVO>(){}.type
        return Gson().fromJson(ListJsonStr,dataListType)
    }
}