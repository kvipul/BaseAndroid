package com.sablania.baseandroidlibrary

import android.app.Application
import retrofit2.Response
import retrofit2.Retrofit

/**
 * @author Vipul Kumar on 18/07/20.
 */
open class BaseRepository(application: Application) {

    val TAG = this::class.java.simpleName

    fun getRetrofitClient(baseUrl: String, trustAllHost: Boolean = false): Retrofit =
        RetrofitProvider(baseUrl, trustAllHost).getRetrofitInstance()

    /**
     * returns Pair<isSuccessful, ErrorMsg/ResponseBody>
     */
    protected suspend fun <T> processNetworkRequest(request: suspend () -> Response<T>): Pair<Boolean, Any?> {
        return try {
            val call = request.invoke()
            Pair(call.isSuccessful, call.body())
        } catch (e: Exception) {
            MyLog.i(TAG, e.message)
            MyLog.i(TAG, e.localizedMessage)
            MyLog.i(TAG, e.toString())
            e.cause?.logStackTrace()
            e.logStackTrace()
            //Type of error can be handled here such as NetworkError, ServerError
            Pair(false, e.message)
        }
    }
}