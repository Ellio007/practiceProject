package com.tyh.practiceproject.utils

object ClickUtil {
    private const val MIN_DELAY_TIME = 1000 // 默认两次点击间隔不能少于1000ms
    private var lastClickTime: Long = 0

    fun isFastClick(minDelayTime: Int = MIN_DELAY_TIME): Boolean {
        var flag = true
        val currentClickTime = System.currentTimeMillis()
        if (currentClickTime - lastClickTime >= minDelayTime) {
            flag = false
        }
        lastClickTime = currentClickTime
        return flag
    }
}