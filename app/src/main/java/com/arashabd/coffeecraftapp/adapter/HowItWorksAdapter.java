package com.arashabd.coffeecraftapp.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arashabd.coffeecraftapp.R;
import com.arashabd.coffeecraftapp.models.ModelHowItWorks;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.RecyclerView;
import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;

public class HowItWorksAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<ModelHowItWorks> items;

    public HowItWorksAdapter(List<ModelHowItWorks> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new IMAGEViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_preparation_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((IMAGEViewHolder) holder).onBind(holder.getAdapterPosition());

    }


    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }


    @SuppressLint("NotifyDataSetChanged")
    public void addItems(List<ModelHowItWorks> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }


    @SuppressLint("NotifyDataSetChanged")
    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    ModelHowItWorks getItem(int position) {
        return items.get(position);
    }

    public class IMAGEViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView description;
        ImageView icon;

        IMAGEViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            icon = itemView.findViewById(R.id.icon);
            description = itemView.findViewById(R.id.description);
          //  ButterKnife.bind(this, itemView);
        }

        public void onBind(int position) {
            // super.onBind(position);
            ImageLoader imageLoader = Coil.imageLoader(icon.getContext());
            ImageRequest request = new ImageRequest.Builder(icon.getContext())
                    .data(items.get(position).getIcon())
                    .crossfade(true)
                    .target(icon)
                    .build();
            imageLoader.enqueue(request);
//            Glide.with(icon.getContext())
//                    .asDrawable()
//                    .load(items.get(position).getIcon())
//                    .error(R.drawable.ic_time)
//                    .into(icon);
            ModelHowItWorks item = items.get(position);
            title.setText(item.getTitle());
            description.setText(HtmlCompat.fromHtml((item.getDescription()), HtmlCompat.FROM_HTML_MODE_LEGACY));
        }
    }

}




