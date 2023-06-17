package com.jhonjto.prettytoast

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class InfoToast(context: Context, message: String) : LinearLayout(context) {
    init {
        show(context, message)
    }

    private fun show(context: Context, message: String) {
        val view = LayoutInflater.from(context).inflate(R.layout.info_toast, this, true)
        val textView = findViewById<View>(R.id.text) as TextView
        textView.text = message
        val toast = Toast(context)
        toast.duration = Toast.LENGTH_LONG
        toast.view = view
        toast.show()
    }
}