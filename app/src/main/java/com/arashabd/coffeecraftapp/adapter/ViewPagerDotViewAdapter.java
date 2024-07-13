package com.arashabd.coffeecraftapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.arashabd.coffeecraftapp.R;
import com.arashabd.coffeecraftapp.models.ServingModel;

import java.util.List;
import java.util.Objects;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;

public class ViewPagerDotViewAdapter extends PagerAdapter {

    private final Context context;
    private final List<ServingModel> servingModel;

    public ViewPagerDotViewAdapter(Context context, List<ServingModel> servingModel) {
        this.context = context;
        this.servingModel = servingModel;
    }

    @Override
    public int getCount() {
        return servingModel.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE
        );
        View view = layoutInflater.inflate(R.layout.adapter_dot_view_viewpager, null);
        ImageView imageView = view.findViewById(R.id.image_view);
        ProgressBar progress = view.findViewById(R.id.progressBar);
        TextView description = view.findViewById(R.id.description);
        String link;
        if(!Objects.requireNonNull(servingModel.get(position).getImageURL()).contains("https"))
            link = Objects.requireNonNull(servingModel.get(position).getImageURL()).replace("http", "https");
        else link = servingModel.get(position).getImageURL();
        ImageLoader imageLoader = Coil.imageLoader(context);
        ImageRequest request = new ImageRequest.Builder(context)
                .data(link)
                .crossfade(true)
                .target(imageView)
                .build();
        imageLoader.enqueue(request);
//        GlideHelperKt.glideHelper(context,
//                imageView,
//                link,
//                progress
//        );
        description.setText(servingModel.get(position).getDescription());
        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}
