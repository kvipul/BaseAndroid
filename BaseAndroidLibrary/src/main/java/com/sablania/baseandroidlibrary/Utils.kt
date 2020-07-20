package com.sablania.baseandroidlibrary

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * @author Vipul Kumar on 19/07/20.
 */
fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun Context.openImageInGallery(imageUrl: String) {
    val intent = Intent();
    intent.setAction(Intent.ACTION_VIEW);
    intent.setDataAndType(Uri.parse(imageUrl), "image/*");
    startActivity(intent);
}