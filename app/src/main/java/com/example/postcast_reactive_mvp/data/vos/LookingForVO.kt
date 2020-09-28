package com.example.postcast_reactive_mvp.data.vos

import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName

@IgnoreExtraProperties
data class LookingForVO(
    @SerializedName("cohosts")val cohosts: Boolean? = null,
    @SerializedName("cross_promotion")val cross_promotion: Boolean? = null,
    @SerializedName("guests")val guests: Boolean? = null,
    @SerializedName("sponsors")val sponsors: Boolean? = null
)