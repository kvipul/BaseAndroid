package com.sablania.baseandroidlibrary

import android.app.Application
import retrofit2.Retrofit

/**
 * @author Vipul Kumar on 18/07/20.
 */
open class BaseRepository(application: Application) {

    fun getRetrofitClient(baseUrl: String): Retrofit = RetrofitProvider(baseUrl).getRetrofitInstance()

}