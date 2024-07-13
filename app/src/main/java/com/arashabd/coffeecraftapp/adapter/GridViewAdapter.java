//package com.arashabd.coffeecraftapp.adapter;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import com.arashabd.coffeecraftapp.R;
//import com.arashabd.coffeecraftapp.utils.LoadSvgWithGlideKt;
//import java.util.ArrayList;
//
//import androidx.lifecycle.DefaultLifecycleObserver;
//import androidx.lifecycle.LifecycleObserver;
//import androidx.lifecycle.LifecycleOwner;
//
//public class GridViewAdapter extends BaseAdapter {
//    private final Context mContext;
//    private final ArrayList<String> imageIcons;
//    private final ArrayList<String> texts;
//
//    // Constructor
//    public GridViewAdapter(Context c, ArrayList<String> imageIcons, ArrayList<String> texts) {
//        mContext = c;
//        this.imageIcons = imageIcons;
//        this.texts = texts;
//    }
//
//    public int getCount() {
//        return imageIcons.size();
//    }
//
//    public Object getItem(int position) {
//        return null;
//    }
//
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @SuppressLint("InflateParams")
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        LayoutInflater inflater = (LayoutInflater) mContext
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//        View gridView;
//
//        if (convertView == null) {
//            gridView = inflater.inflate(R.layout.gridview_custom_layout, null);
//            ImageView imageView = gridView.findViewById(R.id.image);
//            ProgressBar progressBar = gridView.findViewById(R.id.progressBar);
//            TextView text = gridView.findViewById(R.id.title);
//
//            Thread thread = new Thread(){
//                @Override
//                public void run() {
//
//                    LoadSvgWithGlideKt.loadSvgWithGlide(mContext, imageIcons.get(position), imageView, progressBar);
//                }
//            };
//             thread.start();
//
//            text.setText(texts.get(position));
//
//        } else {
//            gridView = convertView;
//        }
//
//        return gridView;
//    }
//}
