package com.sult.tm.sultstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sult.tm.sultstore.adapter.ProductAdapter;
import com.sult.tm.sultstore.model.Cart;
import com.sult.tm.sultstore.model.Product;

import java.util.ArrayList;
import java.util.List;

public class FavouritesActivity extends AppCompatActivity {

    RecyclerView favouritesRecycler;
    ProductAdapter favouritesAdapter;
    List<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        List<Product> favourites_products = new ArrayList<>();

        productList.add(new Product(1, 1, 490, "product", "preview", "Игровой компьютер G-C1", "Минимальный игровой компьютер который может все! " +
                "Он потянет практически любые игры на средних настройках графики и сложные программы. Тем не менее, его строгий дизайн, относительно небольшие габариты и отсутствие шума при" +
                "использовании привлекают покупателей к его покупке", "Категория: Компьютеры\n\nТип товара: Настольный компьютер\n\nВид товара: Игровой компьютер\n\nКласс: simple\n\nОсновной цвет: черный", false));
        productList.add(new Product(2, 2, 550, "product", "preview","Игровой ноутбук","Отличное игровое решение, сочетающее в себе высокую производительность, " +
                "красочный экран с высокими разрешением и частотой и прекрасный звук. Он потянет любые требовательные игры на средне-высоких настройках и сложные программы. " +
                "Строгий дизайн, невероятная тонкость делают этот ноутбук приятным и удобным для его использования. Именно эти качества и делают его лучшим среди оппонентов",
                "Категория: Ноутбуки\n\nТип товара: Ноутбук\n\nВид товара: Игровой ноутбук\n\nКласс: medium\n\nОсновной цвет: черный", false));
        productList.add(new Product(3, 3, 0,"product", "preview","Test","Test is a test but not a test, that`s why it`s a test! Wow, you would be say, but it`s true!",
                "Категория: test\n\nТип товара: test\n\nВид товара: test\n\nКласс: test\n\nОсновной цвет: test", false));
        productList.add(new Product(4, 3, 0,"product", "preview","Test","Test is a test but not a test, that`s why it`s a test! Wow, you would be say, but it`s true!",
                "Категория: test\n\nТип товара: test\n\nВид товара: test\n\nКласс: test\n\nОсновной цвет: test", false));

        for (Product pr : productList) {
            if (Cart.favourites_id.contains(pr.getId())) {
                favourites_products.add(pr);
            }
        }
        setProductRecycler(favourites_products);
    }

    private void setProductRecycler(List<Product> productList) {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);

        favouritesRecycler = findViewById(R.id.favourites_recycler);
        favouritesRecycler.setLayoutManager(layoutManager);

        favouritesAdapter = new ProductAdapter(this, productList);
        favouritesRecycler.setAdapter(favouritesAdapter);
    }
}