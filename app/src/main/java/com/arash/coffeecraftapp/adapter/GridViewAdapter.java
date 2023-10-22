package com.arash.coffeecraftapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.arash.coffeecraftapp.R;
import com.arash.coffeecraftapp.utils.LoadSvgWithGlideKt;
import com.arash.coffeecraftapp.utils.SvgDecoder;
import com.arash.coffeecraftapp.utils.SvgDrawableTranscoder;
import com.arash.coffeecraftapp.utils.SvgSoftwareLayerSetter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;
import com.caverock.androidsvg.SVG;

import java.io.InputStream;
import java.util.ArrayList;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class GridViewAdapter extends BaseAdapter {
    private final Context mContext;
    private final ArrayList<String> imageIcons;
    private final ArrayList<String> texts;
    private RequestBuilder<PictureDrawable> requestBuilder;

    // Constructor
    public GridViewAdapter(Context c, ArrayList<String> imageIcons, ArrayList<String> texts) {
        mContext = c;
        this.imageIcons = imageIcons;
        this.texts = texts;
    }

    public int getCount() {
        return imageIcons.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("InflateParams")
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {
            gridView = inflater.inflate(R.layout.gridview_custom_layout, null);
            ImageView imageView = gridView.findViewById(R.id.image);
            ProgressBar progressBar = gridView.findViewById(R.id.progressBar);
            TextView text = gridView.findViewById(R.id.title);
//            requestBuilder =
//                    Glide.with(imageView)
//                            .as(PictureDrawable.class)
//                            .error(R.drawable.ic_grid_image_6)
//                            .decode(SvgDecoder.class)
//                            .transition(withCrossFade())
//                            .listener(new SvgSoftwareLayerSetter());
//            Uri uri = Uri.parse(imageIcons.get(position));
//            requestBuilder
//                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
////                    // SVG cannot be serialized so it's not worth to cache it
//                    .load(uri)
//                    .into(imageView);
            Thread thread = new Thread(){
                @Override
                public void run() {
                    LoadSvgWithGlideKt.loadSvgWithGlide(imageIcons.get(position), imageView, progressBar);
                }
            };
             thread.start();
//             requestBuilder = Glide.with(imageView).as(PictureDrawable.class).error(R.drawable.ic_grid_image_2).load(imageIcons.get(position));
//             apply(
//                            new RequestOptions()
//                                    .error(R.drawable.ic_grid_image_1)
//                                    .centerCrop()
//                    )
//            Uri uri = Uri.parse(imageIcons.get(position));
//            requestBuilder
//                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
////                    // SVG cannot be serialized so it's not worth to cache it
//                    .load(uri)
//                    .into(imageView);
                //.into(imageView);
          //  imageView.setImageDrawable(AppCompatResources.getDrawable(mContext, R.drawable.ic_grid_image_1));
            text.setText(texts.get(position));

        } else {
            gridView = convertView;
        }
        return gridView;
    }
}
