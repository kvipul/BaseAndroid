package com.sablania.baseandroidlibrary

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.remoteconfig.FirebaseRemoteConfig

/**
 * @author Vipul Kumar on 15/08/20.
 */
object BaseAndroidLibrary {
    internal lateinit var firebaseCrashlytics: FirebaseCrashlytics
    internal lateinit var firebaseAnalytics: FirebaseAnalytics
    internal lateinit var firebaseRemoteConfig: FirebaseRemoteConfig

    fun setFirebaseCrashlytics(firebaseCrashlytics: FirebaseCrashlytics) = this.apply {
        this.firebaseCrashlytics = firebaseCrashlytics
    }

    fun setFirebaseAnalytics(firebaseAnalytics: FirebaseAnalytics) = this.apply {
        this.firebaseAnalytics = firebaseAnalytics
    }

    fun setFirebaseRemoteConfig(firebaseRemoteConfig: FirebaseRemoteConfig) = this.apply {
        this.firebaseRemoteConfig = firebaseRemoteConfig
    }
}