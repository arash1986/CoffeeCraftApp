package com.arash.coffeecraftapp.utils
import android.graphics.drawable.Drawable
import android.graphics.drawable.PictureDrawable
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.arash.coffeecraftapp.R
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.caverock.androidsvg.SVG
import java.io.InputStream
import java.net.URL
import com.bumptech.glide.request.target.Target

fun loadSvgWithGlide(url: String, target: ImageView, progressBar: ProgressBar) {
    var requestBuilder: RequestBuilder<PictureDrawable>? = null

    // Load the SVG image from the URL using AndroidSVG
    val sdk = Build.VERSION.SDK_INT
    if (sdk > 8) {
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
    Handler(Looper.getMainLooper()).post {
        glideHelper(target, pictureDrawable, progressBar)
//        Glide.with(target.context).asDrawable()
//            // .`as`(PictureDrawable::class.java)
//            .error(R.drawable.ic_grid_image_6)
//            //.decode(SvgDecoder::class.java)
//            .transition(DrawableTransitionOptions.withCrossFade())
//
//            // val uri = Uri.parse(pictureDrawable)
//
//            .diskCacheStrategy(DiskCacheStrategy.RESOURCE) //                    // SVG cannot be serialized so it's not worth to cache it
//            .load(pictureDrawable)
//            .listener(object : RequestListener<Drawable> {
//                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
//
//                    return false
//                }
//
//                override fun onResourceReady(
//                    resource: Drawable?,
//                    model: Any?,
//                    target: Target<Drawable>?,
//                    dataSource: DataSource?,
//                    isFirstResource: Boolean
//                ): Boolean {
//                    progressBar.visibility = View.GONE
//                    return false
//                }
//            })
//            .into(target)
    }
//        Glide.with(target.context)
//            .load(pictureDrawable)
//           // .apply(options)
//            .into(target)

}