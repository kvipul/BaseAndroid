package com.sablania.baseandroidlibrary

import com.google.firebase.crashlytics.FirebaseCrashlytics

/**
 * @author Vipul Kumar on 15/08/20.
 */
object BaseAndroidLibrary {
    internal lateinit var firebaseCrashlytics: FirebaseCrashlytics

    fun setUpLibrary(firebaseCrashlytics: FirebaseCrashlytics) {
        this.firebaseCrashlytics = firebaseCrashlytics
    }
}