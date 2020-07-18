package com.sablania.baseandroid

import android.os.Bundle
import com.sablania.baseandroidlibrary.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}