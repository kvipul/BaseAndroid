package com.sablania.baseandroidlibrary

import android.content.Context
import android.os.Bundle
import android.util.Log
import com.google.firebase.analytics.FirebaseAnalytics
import com.sablania.baseandroidlibrary.BaseAndroidLibrary.firebaseCrashlytics

/**
 * @author Vipul Kumar on 15/08/20.
 */

class MyLog {
    companion object {
        fun i(tag: String?, msg: String) {
            Log.i((tag ?: "").plus("Sablania"), msg)
            firebaseCrashlytics.log((tag ?: "").plus(" ").plus(msg))
        }

        fun w(tag: String?, msg: String) {
            Log.w((tag ?: "").plus("Sablania"), msg)
            firebaseCrashlytics.log((tag ?: "").plus(" ").plus(msg))
        }

        fun e(tag: String?, msg: String) {
            Log.e((tag ?: "").plus("Sablania"), msg)
            firebaseCrashlytics.log((tag ?: "").plus(" ").plus(msg))
        }
    }
}

fun logEvent(context: Context, eventName: String, bundle: Bundle?) {
    FirebaseAnalytics.getInstance(context).logEvent(eventName, bundle)
}

fun Exception.logStackTrace() {
    printStackTrace()
    firebaseCrashlytics.recordException(this)
}