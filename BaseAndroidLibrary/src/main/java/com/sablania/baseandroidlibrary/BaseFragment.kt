package com.sablania.baseandroidlibrary

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

/**
 * @author Vipul Kumar on 18/07/20.
 */
open class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun getViewModelProvider(viewModelStoreOwner: ViewModelStoreOwner): ViewModelProvider {
        return ViewModelProvider(
            viewModelStoreOwner,
            ViewModelProvider.AndroidViewModelFactory(activity!!.application)
        )
    }

    open fun getFragmentName() = this::class.java.simpleName
}