package com.sult.tm.sultstore.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sult.tm.sultstore.R;
import com.sult.tm.sultstore.SearchActivity;
import com.sult.tm.sultstore.model.Filter;

import java.util.List;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.FilterViewHolder>{

    Context context;
    List<Filter> filters;

    public FilterAdapter(Context context, List<Filter> filters) {
        this.context = context;
        this.filters = filters;
    }

    @NonNull
    @Override
    public FilterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View filterItems = LayoutInflater.from(context).inflate(R.layout.filter_item, parent, false);
        return new FilterViewHolder(filterItems);
    }

    @Override
    public void onBindViewHolder(@NonNull FilterAdapter.FilterViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.filterTitle.setText(filters.get(position).getTitle());

        holder.itemView.setOnClickListener(v -> {
            SearchActivity.show = true;
            SearchActivity.showFilter = filters.get(position).getId();
        });
    }

    @Override
    public int getItemCount() {
        return filters.size();
    }

    public static final class FilterViewHolder extends RecyclerView.ViewHolder {

        TextView filterTitle;

        public FilterViewHolder(@NonNull View itemView) {
            super(itemView);

            filterTitle = itemView.findViewById(R.id.filterTitle);
        }
    }

}
