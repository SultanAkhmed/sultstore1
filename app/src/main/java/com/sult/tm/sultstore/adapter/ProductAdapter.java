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

import com.sult.tm.sultstore.ProductPageActivity;
import com.sult.tm.sultstore.R;
import com.sult.tm.sultstore.model.Cart;
import com.sult.tm.sultstore.model.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductsViewHolder> {

    Context context;
    List<Product> products;

    public ProductAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productItems = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new ProductsViewHolder(productItems);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductsViewHolder holder, @SuppressLint("RecyclerView") int position) {
        @SuppressLint("DiscouragedApi") int imageId = context.getResources().getIdentifier(products.get(position).getImg(), "drawable", context.getPackageName());
        holder.productImage.setImageResource(imageId);

        holder.productTitle.setText(products.get(position).getTitle());
        holder.productPrice.setText(products.get(position).getPrice() + "$");

        int favourite_id = products.get(position).getId();

        if (Cart.favourites_id.contains(favourite_id)) {
            holder.productFaveImage.setImageResource(R.drawable.favourite2);
        } else {
            holder.productFaveImage.setImageResource(R.drawable.favourite1);
        }

        holder.productFaveImage.setOnClickListener(v -> {
            if (!Cart.favourites_id.contains(favourite_id)) {
                Cart.favourites_id.add(favourite_id);
                holder.productFaveImage.setImageResource(R.drawable.favourite2);
            } else {
                Cart.favourites_id.remove(favourite_id);
                holder.productFaveImage.setImageResource(R.drawable.favourite1);
            }
        });

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, ProductPageActivity.class);
            intent.putExtra("productTitle", products.get(position).getTitle());
            intent.putExtra("productPrice", products.get(position).getPrice());
            intent.putExtra("productText", products.get(position).getText());
            intent.putExtra("productSpec", products.get(position).getSpec());
            intent.putExtra("productId", products.get(position).getId());

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static final class ProductsViewHolder extends RecyclerView.ViewHolder {

        ImageView productImage, productFaveImage;
        TextView productTitle, productPrice;

        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage);
            productFaveImage = itemView.findViewById(R.id.addToFavourites);
            productTitle = itemView.findViewById(R.id.productTitle);
            productPrice = itemView.findViewById(R.id.productPrice);
        }
    }

}