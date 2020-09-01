package com.example.postcast_reactive_mvp.util

import com.example.postcast_reactive_mvp.BuildConfig


const val BASE_URL = BuildConfig.BASE_URL_FIELD

const val API_KEY = BuildConfig.API_KEY

const val GET_RANDOM_PODCAST_EPISOE = "just_listen"
const val GET_PODCAST_GENER = "genres"

const val GET_PLAYLIST_INFO_AND_ITEM = "playlists/{id}?type=episode_list&last_timestamp_ms=0&sort=recent_added_first"
const val GET_DETAIL_FOR_EPISODE = "episodes/{id}"



const val EN_ERROR_MESSAGE = "Check your internet connection"