package com.tyh.practiceproject.ui

import android.graphics.drawable.Animatable
import android.widget.ImageView

object AnimationUtils {

    fun startAnim(imageView: ImageView) {
        val drawable = imageView.drawable
        if (drawable is Animatable) {
            (drawable as Animatable).start()
        }
    }
}