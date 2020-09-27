package com.example.postcast_reactive_mvp.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName

@IgnoreExtraProperties
@Entity(tableName = "gener")
data class GenreVO(
    @PrimaryKey

    @SerializedName("id")var id: Int = 0,
    @SerializedName("name")var name: String? = "",
    @SerializedName("parent_id")var parent_id: Int? = 0,
    @SerializedName("image_url")var image_url :String? = ""
//   var id: Int,
//   var name: String,
//   var parent_id: Int,
//   var image_url :String

)
{}
