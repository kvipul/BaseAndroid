package com.sablania.baseandroidlibrary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.sablania.baseandroidlibrary.databinding.FragmentBaseBinding
import java.lang.RuntimeException

/**
 * @author Vipul Kumar on 18/07/20.
 */
abstract class BaseFragment : Fragment() {

    private lateinit var baseBinding: FragmentBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        baseBinding = FragmentBaseBinding.inflate(inflater, container, false)
        return baseBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!::baseBinding.isInitialized) {
            throw RuntimeException("Please call super() when you override onCreateView()")
        }
        baseBinding.apply {
            layoutError.tvRetry.setOnClickListener {
                refreshData()
            }
        }
    }

    fun getViewModelProvider(viewModelStoreOwner: ViewModelStoreOwner): ViewModelProvider {
        return ViewModelProvider(
            viewModelStoreOwner,
            ViewModelProvider.AndroidViewModelFactory(activity!!.application)
        )
    }

    open fun getFragmentName() = this::class.java.simpleName

    abstract fun refreshData()

    protected fun showProgress() {
        baseBinding.apply {
            layoutProgress.root.isVisible = true
            layoutError.root.isVisible = false
            contentFrame.isVisible = false
        }
    }

    protected fun showError() {
        baseBinding.apply {
            layoutProgress.root.isVisible = false
            layoutError.root.isVisible = true
            contentFrame.isVisible = false
        }
    }

    protected fun showContent() {
        baseBinding.apply {
            layoutProgress.root.isVisible = false
            layoutError.root.isVisible = false
            contentFrame.isVisible = true
        }
    }
}