package com.sult.tm.sultstore;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sult.tm.sultstore.adapter.FilterAdapter;
import com.sult.tm.sultstore.adapter.ProductAdapter;
import com.sult.tm.sultstore.model.Check;
import com.sult.tm.sultstore.model.Filter;
import com.sult.tm.sultstore.model.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    RecyclerView filterRecycler, productRecycler;
    EditText searchText;
    ImageView search;
    FilterAdapter filterAdapter;
    ProductAdapter productAdapter;
    List<Filter> filterList = new ArrayList<>();
    List<Product> productList = new ArrayList<>();
    List<Product> allProductsList = new ArrayList<>();
    public static Boolean show = false;
    public static int showFilter = 0;
    static Boolean checkPriceFrom = false;
    static Boolean checkPriceTo = false;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        init();

        searchText.setText(MainActivity.search_text);
        MainActivity.search_text = "";

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

        filterList.add(new Filter(1, "Компьютеры"));
        filterList.add(new Filter(2, "Ноутбуки"));
        filterList.add(new Filter(3, "Приставки"));

        allProductsList.addAll(productList);

        setProductRecycler(productList);
        onSearch(MainActivity.onSearch);

        if (show) {
            showFilterProducts(showFilter);
        }
        setFilterRecycler(filterList);
        setFilter(FilterActivity.onAccept);
    }

    private void setFilterRecycler(List<Filter> filterList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        filterRecycler = findViewById(R.id.filterRecycler);
        filterRecycler.setLayoutManager(layoutManager);

        filterAdapter = new FilterAdapter(this, filterList);
        filterRecycler.setAdapter(filterAdapter);
    }

    private void setProductRecycler(List<Product> productList) {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);

        productRecycler = findViewById(R.id.productRecycler);
        productRecycler.setLayoutManager(layoutManager);

        productAdapter = new ProductAdapter(this, productList);
        productRecycler.setAdapter(productAdapter);
    }

    public void init(){
        filterRecycler = findViewById(R.id.filterRecycler);
        searchText = findViewById(R.id.search_text);
        search = findViewById(R.id.search);
    }

    public void goMain(View view){
        startActivity(new Intent(SearchActivity.this, MainActivity.class));
    }

    @SuppressLint("NotifyDataSetChanged")
    public void showFilterProducts(int filter){
        productList.clear();
        productList.addAll(allProductsList);

        List<Product> filterProducts = new ArrayList<>();

        for (Product pr : productList) {
            if (pr.getFilter() == filter) {
                filterProducts.add(pr);
            }
        }

        productList.clear();
        productList.addAll(filterProducts);

        productAdapter.notifyDataSetChanged();
    }


    @SuppressLint("NotifyDataSetChanged")
    public void setFilter(View view) {
        if (Check.checkFilter[0]) {
            productList.clear();
            productList.addAll(allProductsList);

            List<Product> compProducts = new ArrayList<>();

            for (Product pr : productList) {
                if (pr.getFilter() == 1) {
                    if (checkPriceFrom & checkPriceTo) {
                        if (pr.getPrice() >= FilterActivity.priceFrom || pr.getPrice() <= FilterActivity.priceTo) {
                            compProducts.add(pr);
                        }
                    } else {
                        compProducts.add(pr);
                    }
                }
            }

            checkPriceFrom = false;
            checkPriceTo = false;

            productList.clear();
            productList.addAll(compProducts);
            productAdapter.notifyDataSetChanged();

        } else if (Check.checkFilter[1]) {
            productList.clear();
            productList.addAll(allProductsList);

            List<Product> noteProducts = new ArrayList<>();

            for (Product pr : productList) {
                if (pr.getFilter() == 2) {
                    if (checkPriceFrom & checkPriceTo) {
                        if (pr.getPrice() >= FilterActivity.priceFrom || pr.getPrice() <= FilterActivity.priceTo) {
                            noteProducts.add(pr);
                        }
                    } else {
                        noteProducts.add(pr);
                    }
                }
            }

            checkPriceFrom = false;
            checkPriceTo = false;

            productList.clear();
            productList.addAll(noteProducts);
            productAdapter.notifyDataSetChanged();

        } else if (Check.checkFilter[2]) {
            productList.clear();
            productList.addAll(allProductsList);

            List<Product> gameProducts = new ArrayList<>();

            for (Product pr : productList) {
                if (pr.getFilter() == 3) {
                    if (checkPriceFrom & checkPriceTo) {
                        if (pr.getPrice() >= FilterActivity.priceFrom || pr.getPrice() <= FilterActivity.priceTo) {
                            gameProducts.add(pr);
                        }
                    } else {
                        gameProducts.add(pr);
                    }
                }
            }

            checkPriceFrom = false;
            checkPriceTo = false;

            productList.clear();
            productList.addAll(gameProducts);
            productAdapter.notifyDataSetChanged();

        } else {
            if (checkPriceFrom || checkPriceTo) {
                productList.clear();
                productList.addAll(allProductsList);

                List<Product> priceFilterProducts = new ArrayList<>();

                for (Product pr : productList) {
                    if (pr.getPrice() >= FilterActivity.priceFrom || pr.getPrice() <= FilterActivity.priceTo) {
                        priceFilterProducts.add(pr);
                    }
                }

                checkPriceFrom = false;
                checkPriceTo = false;

                productList.clear();
                productList.addAll(priceFilterProducts);
                productAdapter.notifyDataSetChanged();
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    public void onSearch(View view){
        if (!searchText.getText().toString().equals("")) {
            productList.clear();
            productList.addAll(allProductsList);

            List<Product> searchProducts = new ArrayList<>();

            for(Product pr : productList){
                if (pr.getTitle().equalsIgnoreCase(searchText.getText().toString())){
                    searchProducts.add(pr);
                }
            }

            productList.clear();
            productList.addAll(searchProducts);
            productAdapter.notifyDataSetChanged();
        } else {
            productList.clear();
            productList.addAll(allProductsList);
            productAdapter.notifyDataSetChanged();
        }
    }

    public void openFilters(View view){
        startActivity(new Intent(SearchActivity.this, FilterActivity.class));
    }
}