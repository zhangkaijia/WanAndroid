package com.tw.wanandroid.ext

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 *
 * @author TW,uidq3844
 * Time: 2023-8-28 20:37
 * Description:
 *
 * Copyright (c) 2023 Desaysv All rights reserved.
 */

/**
 * 隐藏键盘
 */
fun View?.hideSoftKeyboard() {
    if (this == null) {
        return
    }
    this.clearFocus()
    (this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
        .hideSoftInputFromWindow(this.windowToken, 0)
}