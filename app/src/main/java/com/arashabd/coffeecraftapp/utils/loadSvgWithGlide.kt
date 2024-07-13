//package com.arashabd.coffeecraftapp.utils
//import android.content.Context
//import android.graphics.drawable.PictureDrawable
//import android.os.Build
//import android.os.Handler
//import android.os.Looper
//import android.os.StrictMode
//import android.os.StrictMode.ThreadPolicy
//import android.widget.ImageView
//import android.widget.ProgressBar
//import com.bumptech.glide.RequestBuilder
//import com.caverock.androidsvg.SVG
//import java.io.InputStream
//import java.net.URL
//
//fun loadSvgWithGlide(context: Context, url: String, target: ImageView, progressBar: ProgressBar) {
//    // Load the SVG image from the URL using AndroidSVG
//    val sdk = Build.VERSION.SDK_INT
//    if (sdk > 8) {
//        val policy = ThreadPolicy.Builder()
//            .permitAll().build()
//        StrictMode.setThreadPolicy(policy)
//    }
//        val inputStream: InputStream = URL(url).openStream()
//        val svg: SVG = SVG.getFromInputStream(inputStream)
//        // Convert the SVG to a Bitmap
//        val pictureDrawable = PictureDrawable(svg.renderToPicture())
//
//   // Handler(Looper.getMainLooper()).post {
//        glideHelper(context, target, pictureDrawable, progressBar)
//
//
// //   }
//}