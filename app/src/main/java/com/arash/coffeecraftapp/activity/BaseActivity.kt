package com.arash.coffeecraftapp.activity

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.arash.coffeecraftapp.R
import com.arash.coffeecraftapp.utils.Constants
import com.arash.coffeecraftapp.utils.SessionManager
import org.aviran.cookiebar2.CookieBar

open class BaseActivity: AppCompatActivity() {
    var pDialog: Dialog? = null

    lateinit var sessionManager : SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  initProgressDialog()
        sessionManager = SessionManager(this)
    }

//    open fun initProgressDialog() {
//        pDialog = Dialog(this, R.style.AnimatedDialog)
//        pDialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        pDialog!!.setContentView(R.layout.dialog_view_loading_new)
//        val mainTitle: TextView = pDialog!!.findViewById(R.id.mainTitle)
//        mainTitle.text = getString(R.string.loading_your_data)
//        val width = (resources.displayMetrics.widthPixels * 0.90).toInt()
//        pDialog!!.window!!.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
//        pDialog!!.setCancelable(false)
//    }
//
//    open fun initProgressDialog(mainTitle: String?) {
//        pDialog = Dialog(this, R.style.AnimatedDialog)
//        pDialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        pDialog!!.setContentView(R.layout.dialog_view_loading_new)
//        val mainTitleTextView: TextView = pDialog!!.findViewById(R.id.mainTitle)
//        mainTitleTextView.text = mainTitle.toString()
//        val width = (resources.displayMetrics.widthPixels * 0.90).toInt()
//        pDialog!!.window!!.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
//        pDialog!!.setCancelable(false)
//    }
//
////    open fun showToast(mode: String?, content: String, context: Context?) {
////        var content = content
////        if (content.lowercase() == "something went wrong" || content.lowercase() == "something went wrong.") content =
////            "Something went wrong"
////        when (mode) {
////            "success" -> CookieBar.build(context as Activity?)
////                .setCookiePosition(CookieBar.TOP)
////                .setCustomView(R.layout.cookie_layout)
////                .setDuration(Constants.cookieBarDuration)
////                .setMessage(content)
////                .setIcon(R.drawable.new_design_cookie_check_circle)
////                .setBackgroundColor(R.color.feedback_light)
////                .setMessageColor(R.color.light_neutral_n900)
////                .show()
////
////            "danger" -> CookieBar.build(context as Activity?)
////                .setCookiePosition(CookieBar.TOP)
////                .setCustomView(R.layout.cookie_layout)
////                .setDuration(toastTime)
////                .setMessage(content)
////                .setIcon(R.drawable.new_design_cookie_error)
////                .setBackgroundColor(R.color.primary_error_light)
////                .setMessageColor(R.color.light_neutral_n900)
////                .show()
////
////            "info" ->                 //call.clone().enqueue(this);
////                CookieBar.build(context as Activity?)
////                    .setCookiePosition(CookieBar.TOP)
////                    .setCustomView(R.layout.cookie_layout)
////                    .setDuration(toastTime)
////                    .setMessage(content)
////                    .setIcon(R.drawable.new_design_cookie_info)
////                    .setBackgroundColor(R.color.primary_50)
////                    .setMessageColor(R.color.light_neutral_n900)
////                    .show()
////
////            "network" ->                 //call.clone().enqueue(this);
////                CookieBar.build(context as Activity?)
////                    .setCookiePosition(CookieBar.TOP)
////                    .setCustomView(R.layout.cookie_layout)
////                    .setDuration(toastTime)
////                    .setMessage(content)
////                    .setIcon(R.drawable.unstable_connection)
////                    .setBackgroundColor(R.color.warning)
////                    .setMessageColor(R.color.light_neutral_n900)
////                    .show()
////        }
////    }

}