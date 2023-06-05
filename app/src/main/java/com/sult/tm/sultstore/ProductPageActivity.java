package com.sult.tm.sultstore;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
//import android.widget.ImageView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sult.tm.sultstore.model.Cart;
import com.sult.tm.sultstore.model.Product;

public class ProductPageActivity extends AppCompatActivity {

    ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);
        cart = findViewById(R.id.addToCart);

        int cart_id = getIntent().getIntExtra("productId", 0);

        if (!Cart.carts_id.contains(cart_id)) {
            cart.setImageResource(R.drawable.add_to_cart);
        } else {
            cart.setImageResource(R.drawable.remove_from_cart);
        }

        TextView productTitle = findViewById(R.id.productPageTitle);
        TextView productDesc = findViewById(R.id.productPageDesc);
        TextView productSpec = findViewById(R.id.productPageSpec);
//        ImageView productImage = findViewById(R.id.productPageImage);

        productTitle.setText(getIntent().getStringExtra("productTitle"));
        productDesc.setText(getIntent().getStringExtra("productText"));
        productSpec.setText(getIntent().getStringExtra("productSpec"));
    }

    public void addToCart(View view){
        int cart_id = getIntent().getIntExtra("productId", 0);

        if (!Cart.carts_id.contains(cart_id)) {
            Cart.carts_id.add(cart_id);
            cart.setImageResource(R.drawable.remove_from_cart);
//            Toast.makeText(this, "Добавлено в корзину", Toast.LENGTH_LONG).show();
        } else {
            Cart.carts_id.remove(cart_id);
            cart.setImageResource(R.drawable.add_to_cart);
        }
    }

//    public void addToCart(View view){
//        int cart_id = getIntent().getIntExtra("productId", 0);
//
//        if (!Cart.cart_id.contains(cart_id)){
//            Cart.cart_id.add(cart_id);
//        }
//
//        Toast.makeText(this, "Добавлено в корзину", Toast.LENGTH_LONG).show();
//    }


//    public void addToFavourites(View view){
//        int favourite_id = getIntent().getIntExtra("productId", 0);
//    }

}