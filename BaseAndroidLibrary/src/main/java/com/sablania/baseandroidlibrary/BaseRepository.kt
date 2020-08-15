package com.sablania.baseandroidlibrary

import android.app.Application
import retrofit2.Retrofit

/**
 * @author Vipul Kumar on 18/07/20.
 */
open class BaseRepository(application: Application) {

    fun getRetrofitClient(baseUrl: String, trustAllHost: Boolean = false): Retrofit =
        RetrofitProvider(baseUrl).getRetrofitInstance()

    val TAG = this::class.java.simpleName

}