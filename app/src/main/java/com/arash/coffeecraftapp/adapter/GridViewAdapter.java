package com.arash.coffeecraftapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.arash.coffeecraftapp.R;
import java.util.ArrayList;
import androidx.appcompat.content.res.AppCompatResources;

public class GridViewAdapter extends BaseAdapter {
    private final Context mContext;
    private final ArrayList<Integer> imageIcons;
    private final ArrayList<String> texts;

    // Constructor
    public GridViewAdapter(Context c, ArrayList<Integer> imageIcons, ArrayList<String> texts) {
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
            TextView text = gridView.findViewById(R.id.title);
            imageView.setImageDrawable(AppCompatResources.getDrawable(mContext, imageIcons.get(position)));
            text.setText(texts.get(position));

        } else {
            gridView = convertView;
        }
        return gridView;
    }
}
