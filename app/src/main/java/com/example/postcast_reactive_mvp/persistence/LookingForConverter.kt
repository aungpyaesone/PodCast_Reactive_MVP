package com.example.postcast_reactive_mvp.persistence

import androidx.room.TypeConverter
import com.example.postcast_reactive_mvp.data.vos.LookingForVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LookingForConverter {
    @TypeConverter
    fun toString(dataList: LookingForVO):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toList(ListJsonStr:String): LookingForVO {
        val dataListType = object : TypeToken<LookingForVO>(){}.type
        return Gson().fromJson(ListJsonStr,dataListType)
    }
}