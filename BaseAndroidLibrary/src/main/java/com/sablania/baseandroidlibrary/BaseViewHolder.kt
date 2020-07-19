package com.sablania.baseandroidlibrary

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Vipul Kumar on 19/07/20.
 */

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun onBind(position:Int, item: Any?)
}