package com.example.customedittext

import android.content.Context
import android.text.Editable
import android.util.AttributeSet
import android.util.Log
import com.google.android.material.internal.ThemeEnforcement
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.theme.overlay.MaterialThemeOverlay
import kotlinx.android.synthetic.main.activity_login.view.*


class CustomTextInputEditText : TextInputEditText {
    // text from xml's attribute
    private var mTitleText: String? = null

    constructor(context: Context) : super(context, null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {

        // obtain all attributes of customized view
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.CustomTextInputEditText, 0, 0)
        val n = typedArray.indexCount
        for (i in 0 until n) {
            val arr = typedArray.getIndex(i) // obtain single attribute of customized view
            when (arr) {
                R.styleable.CustomTextInputEditText_prefillText -> mTitleText = typedArray.getString(arr)
                else -> {
                }
            }
        }

        setPreFillText()

        typedArray.recycle()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    fun setPreFillText() = setText(mTitleText)

    fun setPreFillText(prefillText: String) {
        setText(prefillText)
    }
}
