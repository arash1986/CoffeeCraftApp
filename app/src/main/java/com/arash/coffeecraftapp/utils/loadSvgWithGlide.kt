package com.arash.coffeecraftapp.utils
import android.graphics.drawable.PictureDrawable
import android.os.Build
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.widget.ImageView
import com.arash.coffeecraftapp.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.caverock.androidsvg.SVG
import java.io.InputStream
import java.net.URL


fun loadSvgWithGlide(url: String, target: ImageView) {
        // Load the SVG image from the URL using AndroidSVG
    val SDK_INT = Build.VERSION.SDK_INT
    if (SDK_INT > 8) {
        val policy = ThreadPolicy.Builder()
            .permitAll().build()
        StrictMode.setThreadPolicy(policy)
        //your codes here
    }
        val inputStream: InputStream = URL(url).openStream()
        val svg: SVG = SVG.getFromInputStream(inputStream)

        // Convert the SVG to a Bitmap
        val pictureDrawable = PictureDrawable(svg.renderToPicture())
//    val options: RequestOptions = RequestOptions()
//        .skipMemoryCache(true)
//        .centerInside()
//        .placeholder(R.drawable.ic_main_icon)
//        .fitCenter()
        // Load the Bitmap with Glide
        Glide.with(target.context)
            .load(pictureDrawable)
           // .apply(options)
            .into(target)

}