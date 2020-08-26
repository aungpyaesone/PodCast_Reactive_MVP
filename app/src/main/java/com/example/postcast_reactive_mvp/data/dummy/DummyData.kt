package com.example.postcast_reactive_mvp.data.dummy

import com.example.postcast_reactive_mvp.R
import com.example.postcast_reactive_mvp.data.vos.PodCastVO


fun getAllPodCast():List<PodCastVO>{
    val one = PodCastVO(
        id = 0,
        title = R.string.art_design.toString(),
        description = R.string.category_title.toString(),
        imgUrl = "https://www.incimages.com/uploaded_files/image/1920x1080/getty_470285218_2000133320009280218_277406.jpg"
    )
    val two= PodCastVO(
        id = 0,
        title = R.string.art_design.toString(),
        description = R.string.category_title.toString(),
        imgUrl = "https://trainingindustry.com/content/uploads/2020/01/Ultimate_Podcast_Guide_1920x1080.jpg"
    )

    val three = PodCastVO(
        id = 0,
        title = R.string.art_design.toString(),
        description = R.string.category_title.toString(),
        imgUrl = "https://techcrunch.com/wp-content/uploads/2019/02/podcast-mic-blue.png"
    )
    val four = PodCastVO(
        id = 0,
        title = R.string.art_design.toString(),
        description = R.string.category_title.toString(),
        imgUrl = "https://mir-s3-cdn-cf.behance.net/projects/404/e057aa95308893.Y3JvcCwxMTU2LDkwNCwwLDA.jpg"
    )
    val five = PodCastVO(
        id = 0,
        title = R.string.art_design.toString(),
        description = R.string.category_title.toString(),
        imgUrl = "https://rachelcorbett.com.au/wp-content/uploads/2018/07/Retro-podcast-microphone-on-table.jpg"
    )
    return arrayListOf(one,two,three,four,five)

}