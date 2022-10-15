package com.mmaquera.netgame.extensions

import android.content.Context
import android.widget.Toast

fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT){
    return Toast.makeText(this, message, duration).show()
}