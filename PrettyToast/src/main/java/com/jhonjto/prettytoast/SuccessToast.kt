package com.jhonjto.prettytoast

import android.app.Activity
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.Typeface
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class SuccessToast{
    companion object {
        val GRAVITY_TOP = 48
        val GRAVITY_CENTER = 17
        val GRAVITY_BOTTOM = 80
        private lateinit var layoutInflater: LayoutInflater

        fun successToast(context: Activity, message: String, position: Int) {
            layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(
                R.layout.failed_toast,
                (context).findViewById(R.id.success_toast)
            )
            layout.findViewById<ImageView>(R.id.custom_toast_image).setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_information_24
                )
            )
            val drawable = ContextCompat.getDrawable(context, R.drawable.success_bg)
            drawable?.colorFilter = PorterDuffColorFilter(
                ContextCompat.getColor(context, R.color.success_toast_color),
                PorterDuff.Mode.MULTIPLY
            )
            layout.background = drawable
            layout.findViewById<TextView>(R.id.custom_toast_message).setTextColor(Color.WHITE)
            layout.findViewById<TextView>(R.id.custom_toast_message).text = message
            val toast = Toast(context.applicationContext)
            toast.duration = Toast.LENGTH_SHORT
            if (position == GRAVITY_BOTTOM) {
                toast.setGravity(position, 0, 20)
            } else {
                toast.setGravity(position, 0, 0)
            }
            toast.view = layout //setting the view of custom toast layout
            toast.show()
        }

        fun successToast(context: Activity, message: String, position: Int, font: Typeface?) {
            layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(
                R.layout.failed_toast,
                (context).findViewById(R.id.failed_toast)
            )
            layout.findViewById<ImageView>(R.id.custom_toast_image).setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_information_24
                )
            )
            val drawable = ContextCompat.getDrawable(context, R.drawable.success_bg)
            drawable?.colorFilter = PorterDuffColorFilter(
                ContextCompat.getColor(context, R.color.success_toast_color),
                PorterDuff.Mode.MULTIPLY
            )
            layout.background = drawable
            layout.findViewById<TextView>(R.id.custom_toast_message).setTextColor(Color.WHITE)
            layout.findViewById<TextView>(R.id.custom_toast_message).text = message
            font?.let {
                layout.findViewById<TextView>(R.id.custom_toast_message).typeface = font
            }
            val toast = Toast(context.applicationContext)
            toast.duration = Toast.LENGTH_SHORT
            if (position == GRAVITY_BOTTOM) {
                toast.setGravity(position, 0, 20)
            } else {
                toast.setGravity(position, 0, 0)
            }
            toast.view = layout//setting the view of custom toast layout
            toast.show()
        }

        fun successToast(context: Activity, message: String, position: Int, font: Typeface?, icon: Int) {
            layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(
                R.layout.failed_toast,
                (context).findViewById(R.id.failed_toast)
            )
            layout.findViewById<ImageView>(R.id.custom_toast_image).setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    icon
                )
            )
            val drawable = ContextCompat.getDrawable(context, R.drawable.success_bg)
            drawable?.colorFilter = PorterDuffColorFilter(
                ContextCompat.getColor(context, R.color.success_toast_color),
                PorterDuff.Mode.MULTIPLY
            )
            layout.background = drawable
            layout.findViewById<TextView>(R.id.custom_toast_message).setTextColor(Color.WHITE)
            layout.findViewById<TextView>(R.id.custom_toast_message).text = message
            font?.let {
                layout.findViewById<TextView>(R.id.custom_toast_message).typeface = font
            }
            val toast = Toast(context.applicationContext)
            toast.duration = Toast.LENGTH_SHORT
            if (position == GRAVITY_BOTTOM) {
                toast.setGravity(position, 0, 20)
            } else {
                toast.setGravity(position, 0, 0)
            }
            toast.view = layout//setting the view of custom toast layout
            toast.show()
        }
    }
}