package com.arashabd.coffeecraftapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.arashabd.coffeecraftapp.R



class GridViewNewAdapter(var mContext: Context, var imageIcons: ArrayList<String>, var texts: ArrayList<String>): BaseAdapter() {
    val imageLoader = ImageLoader.Builder(mContext)
        .components {
            add(SvgDecoder.Factory())
        }
        .build()

    private lateinit var imageView: ImageView
    private lateinit var progressBar: ProgressBar
    private lateinit var text: TextView
    override fun getCount(): Int {
        return imageIcons.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    @SuppressLint("CheckResult")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = mContext
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val viewHolder: ViewHolder
        val gridView: View = convertView ?: inflater.inflate(R.layout.gridview_custom_layout, null)
        imageView = gridView.findViewById(R.id.image)
        progressBar = gridView.findViewById(R.id.progressBar)
        text = gridView.findViewById(R.id.title)
        text.text = texts[position]
//        if (mContext is LifecycleOwner) {
//            val lifecycleOwner = mContext as LifecycleOwner
//
//          //  var Dispatchers: Any
//            lifecycleOwner.lifecycleScope.launch(Dispatchers.IO)
//            {
                // Load the SVG image in the background
        val request = ImageRequest.Builder(imageView.context)
            .data(imageIcons[position]). target (
                onStart = { placeholder ->
                    // Handle the placeholder drawable.
                },
                onSuccess = { _ ->
                    progressBar.visibility = View.GONE
                },
                onError = { error ->
                    // Handle the error drawable.
                }
            )
            .target(imageView)
            .build()
        imageLoader.enqueue(request)

     //   loadSvgWithGlide(mContext, imageIcons[position], imageView, progressBar)
//                Glide.with(mContext).asDrawable()
//                    .error(R.drawable.ic_grid_image_6)
//                    .transition(DrawableTransitionOptions.withCrossFade())
//                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
//                    .load(imageIcons[position]).into(imageView)
//                loadSvgWithGlide(
//                    mContext,
//                    imageIcons[position],
//                    imageView,
//                    progressBar
//                )
//                withContext(Dispatchers.Main)
//                {
//                    progressBar.setVisibility(View.GONE)
//                    imageView.setVisibility(View.VISIBLE)
//                }
//            }
      //  }

        return gridView
    }
}