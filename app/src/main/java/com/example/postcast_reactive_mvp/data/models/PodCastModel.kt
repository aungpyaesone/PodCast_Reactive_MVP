package com.example.postcast_reactive_mvp.data.models

import com.example.postcast_reactive_mvp.data.vos.PodCastVO

interface PodCastModel {
    fun getAllPodCast():List<PodCastVO>
}