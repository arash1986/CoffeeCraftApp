package com.arash.coffeecraftapp.utils

import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import com.arash.coffeecraftapp.R

object DialogBuilder {
    private var pDialog: Dialog? = null

//    private fun initProgressDialog() {
//        if(pDialog == null) {
//            pDialog = Dialog(context, R.style.AnimatedDialog)
//            pDialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
//            pDialog!!.setContentView(R.layout.dialog_view_loading_new)
//            val mainTitle: TextView = pDialog!!.findViewById(R.id.mainTitle)
//            mainTitle.text = context.getString(R.string.loading_your_data)
//            val width = (context.resources.displayMetrics.widthPixels * 0.90).toInt()
//            pDialog!!.window!!.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
//            pDialog!!.setCancelable(false)
//        }
//    }

     fun initProgressDialog(context: Context, content: String) {
      //  if(pDialog == null) {
            Log.d("asdasdadas", "here")
            pDialog = Dialog(context, R.style.AnimatedDialog)
            pDialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
            pDialog!!.setContentView(R.layout.dialog_view_loading_new)
            val mainTitleTextView: TextView = pDialog!!.findViewById(R.id.mainTitle)
            mainTitleTextView.text = content
            val width = (context.resources.displayMetrics.widthPixels * 0.90).toInt()
            pDialog!!.window!!.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
            pDialog!!.setCancelable(false)
       // }

         if (!pDialog!!.isShowing) pDialog!!.show()
     }

//    fun showProgressDialog() {
//        if (!pDialog!!.isShowing) pDialog!!.show()
//    }

    fun hideProgressDialog() {
        if (pDialog!!.isShowing) pDialog!!.dismiss()
    }
}