package com.sablania.baseandroidlibrary

import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.*


class RetrofitProvider(val baseUrl: String) {

    companion object {
        private var retrofit: Retrofit? = null
    }

    fun getRetrofitInstance(trustAllHost: Boolean = false): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient(trustAllHost))
                .build()
        }
        return retrofit!!
    }

    fun setRetrofitInstance(retro: Retrofit) {
        retrofit = retro
    }

    private fun getOkHttpClient(trustAllHost: Boolean): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.addNetworkInterceptor(StethoInterceptor())

        if (trustAllHost) {
            try {
                // Create a trust manager that does not validate certificate chains
                val trustAllCerts: Array<TrustManager> = arrayOf<TrustManager>(
                    object : X509TrustManager {
                        override fun checkClientTrusted(
                            chain: Array<out X509Certificate>?,
                            authType: String?
                        ) {
                        }

                        override fun checkServerTrusted(
                            chain: Array<out X509Certificate>?,
                            authType: String?
                        ) {
                        }

                        override fun getAcceptedIssuers(): Array<X509Certificate> {
                            return arrayOf()
                        }
                    }
                )

                // Install the all-trusting trust manager
                val sslContext: SSLContext = SSLContext.getInstance("SSL")
                sslContext.init(null, trustAllCerts, SecureRandom())

                // Create an ssl socket factory with our all-trusting manager
                val sslSocketFactory: SSLSocketFactory = sslContext.socketFactory
                builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
                builder.hostnameVerifier(object : HostnameVerifier {
                    override fun verify(hostname: String?, session: SSLSession?): Boolean {
                        return true
                    }
                })
                builder.build()
            } catch (e: Exception) {
                e.logStackTrace()
                throw RuntimeException(e)
            }
        }

        val okHttpClient = builder.build()

        return okHttpClient
    }
}
