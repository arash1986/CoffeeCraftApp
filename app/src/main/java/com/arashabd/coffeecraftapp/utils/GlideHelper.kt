package com.arashabd.coffeecraftapp.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.arashabd.coffeecraftapp.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

fun glideHelper(context: Context, target: ImageView, pictureDrawable: Any, progressBar: View) {
    if(pictureDrawable is Drawable) {
        Glide.with(context).asDrawable()
            .error(R.drawable.ic_grid_image_6)
            .transition(DrawableTransitionOptions.withCrossFade())
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .load(pictureDrawable)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {

                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar.visibility = View.GONE
                    return false
                }
            })
            .into(target)
    } else {
        val link: String = if(!pictureDrawable.toString().contains("https"))
            pictureDrawable.toString().replace("http", "https")
        else
            pictureDrawable.toString()
        Glide.with(target)
            .load(link)
            .timeout(60000)
            .error(R.drawable.ic_grid_image_6)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    targets: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar.visibility = View.GONE

                    target.setImageDrawable(
                        ContextCompat.getDrawable(
                            target.context,
                            R.drawable.ic_grid_image_6
                        )
                    )
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar.visibility = View.GONE
                    return false
                }
            })
            .into(target)
    }

}