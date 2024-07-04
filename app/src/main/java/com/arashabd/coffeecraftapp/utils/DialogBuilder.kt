package com.arashabd.coffeecraftapp.utils

import android.app.Dialog
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import com.arashabd.coffeecraftapp.R

object DialogBuilder {
    private var pDialog: Dialog? = null

     fun initProgressDialog(context: Context, content: String) {
         Handler(Looper.getMainLooper()).post {
             pDialog = Dialog(context, R.style.AnimatedDialog)
             pDialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
             pDialog!!.setContentView(R.layout.dialog_view_loading_new)
             val mainTitleTextView: TextView = pDialog!!.findViewById(R.id.mainTitle)
             mainTitleTextView.text = content
             val width = (context.resources.displayMetrics.widthPixels * 0.90).toInt()
             pDialog!!.window!!.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
             pDialog!!.setCancelable(false)
             if (!pDialog!!.isShowing) pDialog!!.show()
         }
     }

    fun hideProgressDialog() {
        Handler(Looper.getMainLooper()).post {
            if (pDialog!!.isShowing) pDialog!!.dismiss()
        }
    }
}