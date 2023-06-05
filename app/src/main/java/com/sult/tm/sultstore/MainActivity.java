package com.sult.tm.sultstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.sult.tm.sultstore.model.Product;
import com.sult.tm.sultstore.adapter.ProductAdapter;
import com.sult.tm.sultstore.model.New;
import com.sult.tm.sultstore.adapter.NewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth sAuth;
    RecyclerView productRecycler, newRecycler;
    ProductAdapter productAdapter;
    NewAdapter newAdapter;
    EditText searchText;
    ImageView search;
    @SuppressLint("StaticFieldLeak")
    static ImageView onSearch;
    List<Product> productList = new ArrayList<>();
    static String search_text = "";
    List<New> newList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        onSearch = search;

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


        newList.add(new New(1, "xiaomi", "Скидки на все компьютеры!", "Скидки до -25%\n\nна все компьютеры\n\nSULT STORE",
                "Компью́тер — функциональное устройство, способное выполнять значительный объём вычислений, включая многочисленные арифметические и логические операции, " +
                        "без вмешательства человека. Компьютер может быть как отдельным блоком, так и состоить из нескольких взаимосвязанных устройств. Является синонимом терминов " +
                        "«электронная вычислительная машина», «вычислительная система».", "Скидки до -25% на все компьютеры\n\nИгровые               -10%\n" +
                "\nОфиссные               -25%\n\nРабочие                       -20%"));
        newList.add(new New(2, "apple", "Скидки на все приставки!", "Скидки до -20%\n\nна все приставки\n\nSULT STORE", "Игрова́я приста́вка (игровая консоль) — " +
                "специализированное электронное устройство, предназначенное для видеоигр; для таких устройств, в отличие от персональных компьютеров, запуск и воспроизведение видеоигр " +
                "является основной задачей. Помимо видеоигр, приставки могут дополнительно выступать в качестве устройств для воспроизведения видео и музыки, доступа в Интернет. " +
                "Домашние игровые приставки обычно используются в домашнем быту, используют телевизор, проектор или компьютерный монитор в качестве независимого устройства отображения и " +
                "игровой контроллер в качестве устройства ввода.", "Скидки до -25% на все приставки\n\nPS4, PS5               -10%\n\nXBOX Series S/X               -25%\n" +
                "\nNintendo Switch                       -20%"));
        newList.add(new New(3, "preview", "Скидки на все ноутбуки!", "Скидки до -15%\n\nна все ноутбуки\n\nSULT STORE", "Ноутбук — переносной компьютер, " +
                "в корпусе которого объединены типичные компоненты персонального компьютера, включая дисплей, клавиатуру и устройство указания (обычно сенсорная панель или тачпад), " +
                "а также аккумуляторные батареи. Ноутбуки отличаются небольшими размерами и весом, время автономной работы ноутбуков варьируется. К ноутбукам обычно относят устройства, " +
                "выполненные в раскладном форм-факторе. Ноутбук переносят в сложенном виде, это позволяет защитить экран, клавиатуру и тачпад при транспортировке. " +
                "Также это связано с удобством транспортировки (чаще всего ноутбук транспортируется в портфеле, что позволяет не держать его в руках, а повесить на плечо).",
                "Скидки до -25% на все компьютеры\n\nИгровые MSI               -10%\n\nОфиссные DELL              -25%\n\nРабочие ASUS                      -20%"));

        setProductRecycler(productList);
        setNewRecycler(newList);
    }

    private void setNewRecycler(List<New> newList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        newRecycler = findViewById(R.id.newRecycle);
        newRecycler.setLayoutManager(layoutManager);

        newAdapter = new NewAdapter(this, newList);
        newRecycler.setAdapter(newAdapter);
    }

    private void setProductRecycler(List<Product> productList) {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);

        productRecycler = findViewById(R.id.productRecycler);
        productRecycler.setLayoutManager(layoutManager);

        productAdapter = new ProductAdapter(this, productList);
        productRecycler.setAdapter(productAdapter);
    }

    public void init() {
        sAuth = FirebaseAuth.getInstance();
        searchText = findViewById(R.id.search_text);
        search = findViewById(R.id.search);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void goSearch(View view){
        search_text = searchText.getText().toString();
        if (!search_text.equals("")){
            startActivity(new Intent(MainActivity.this, SearchActivity.class));
        }
    }

    public void goNews(View view){
        startActivity(new Intent(MainActivity.this, NewsActivity.class));
    }

    public void goProfile(View view){
        startActivity(new Intent(MainActivity.this, ProfileActivity.class));
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = sAuth.getCurrentUser();
        if (user == null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }

}