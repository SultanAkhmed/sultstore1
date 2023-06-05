package com.sult.tm.sultstore.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sult.tm.sultstore.NewsActivity;
import com.sult.tm.sultstore.NewsPageActivity;
import com.sult.tm.sultstore.ProductPageActivity;
import com.sult.tm.sultstore.R;
import com.sult.tm.sultstore.model.New;

import java.util.List;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.NewsViewHolder>{

    Context context;
    List<New> news;

    public NewAdapter(Context context, List<New> news) {
        this.context = context;
        this.news = news;
    }

    @NonNull
    @Override
    public NewAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View newItems = LayoutInflater.from(context).inflate(R.layout.new_item, parent, false);
        return new NewsViewHolder(newItems);
    }

    @Override
    public void onBindViewHolder(@NonNull NewAdapter.NewsViewHolder holder, int position) {
        @SuppressLint("DiscouragedApi") int imageId = context.getResources().getIdentifier(news.get(position).getImg(), "drawable", context.getPackageName());
        holder.newImage.setImageResource(imageId);
        holder.newTitle.setText(news.get(position).getTitle());
        holder.newDesc.setText(news.get(position).getDesc());

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, NewsPageActivity.class);
            intent.putExtra("newsTitle", news.get(position).getTitle());
            intent.putExtra("newsDesc", news.get(position).getPageDesc());
            intent.putExtra("newsText", news.get(position).getText());

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public static final class NewsViewHolder extends RecyclerView.ViewHolder {

        ImageView newImage;
        TextView newTitle, newDesc;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            newImage = itemView.findViewById(R.id.newImage);
            newTitle = itemView.findViewById(R.id.newTitle);
            newDesc = itemView.findViewById(R.id.newDesc);
        }
    }

}
