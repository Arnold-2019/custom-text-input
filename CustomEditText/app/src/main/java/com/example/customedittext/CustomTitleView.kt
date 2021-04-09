package com.example.customedittext

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import com.google.android.material.textfield.TextInputLayout


class CustomTitleView : TextInputLayout {
    // 文字
    private var mTitleText: String? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        /**
         * 获得我们所定义的自定义样式属性
         */
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.CustomTitleView, 0, 0)
        val n = typedArray.indexCount
        for (i in 0 until n) {
            val arr = typedArray.getIndex(i) //获得单个属性值
            when (arr) {
                R.styleable.CustomTitleView_titleText -> mTitleText = typedArray.getString(arr)
                else -> {
                }
            }
        }

//        hint = mTitleText

        typedArray.recycle()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    fun setPrefillText(prefilltext: String) {
        hint = prefilltext
    }
}
