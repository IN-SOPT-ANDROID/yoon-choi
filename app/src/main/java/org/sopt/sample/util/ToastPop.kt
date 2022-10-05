package org.sopt.sample.util

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

fun Context.shortToast(stringInfo:String):Unit{
    Toast.makeText(this,stringInfo,Toast.LENGTH_SHORT).show()
}


fun View.defaultSnackbar(stringInfo: String): Unit {
    Snackbar.make(this, stringInfo, Snackbar.LENGTH_SHORT).show()
}