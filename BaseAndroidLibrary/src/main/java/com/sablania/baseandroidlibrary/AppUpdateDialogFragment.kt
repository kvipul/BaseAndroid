package com.sablania.baseandroidlibrary

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.sablania.baseandroidlibrary.databinding.FragmentAppUpdateBinding


/**
 * @author Vipul Kumar on 16/08/20.
 */
class AppUpdateDialogFragment : DialogFragment() {
    private lateinit var binding: FragmentAppUpdateBinding
    private lateinit var appPackageName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appPackageName = arguments?.getString(PACKAGE_NAME)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAppUpdateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        builder.setTitle(R.string.app_update_is_available)
            .setMessage(R.string.please_update_your_app_from_google_play_store)
            .setPositiveButton(getString(R.string.download), null)

        val alertDialog = builder.create()
        alertDialog.setOnShowListener {
            val positiveButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)
            positiveButton.setOnClickListener {
                redirectToPlayStoreApp(context!!, appPackageName)
            }
        }
        return alertDialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isCancelable = false
    }

    companion object {
        const val PACKAGE_NAME = "PACKAGE_NAME"
        fun newInstance(appPackageName: String): AppUpdateDialogFragment {
            return AppUpdateDialogFragment().apply {
                arguments = Bundle().apply {
                    putString(PACKAGE_NAME, appPackageName)
                }
            }
        }
    }

}