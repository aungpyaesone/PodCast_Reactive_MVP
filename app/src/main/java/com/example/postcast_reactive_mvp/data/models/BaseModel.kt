package com.example.postcast_reactive_mvp.data.models

import android.content.Context
import com.example.postcast_reactive_mvp.network.ClientApi
import com.example.postcast_reactive_mvp.persistence.db.PodCastDatabase
import com.example.postcast_reactive_mvp.util.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel{
    protected lateinit var mClientApi : ClientApi
    protected lateinit var mTheDB : PodCastDatabase


    init {

        val interceptor = HttpLoggingInterceptor()
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(mOkHttpClient)
            .build()

        mClientApi = retrofit.create(ClientApi::class.java)
    }

    fun initDatabase(context: Context){
        mTheDB = PodCastDatabase.getDBInstance(context)
    }

}