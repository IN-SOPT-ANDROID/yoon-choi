package org.sopt.sample.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object DataBindingAdapter {
    @JvmStatic
    @BindingAdapter("imgResId")
    fun setImageResId(imageview: ImageView, resId: Int) {
        imageview.setImageResource(resId)
    }
}