package com.sult.tm.sultstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.sult.tm.sultstore.adapter.NewAdapter;
import com.sult.tm.sultstore.model.New;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    RecyclerView newRecycler;
    NewAdapter newAdapter;
    ImageView main, news, profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        init();

        List<New> newList = new ArrayList<>();
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

        setNewRecycler(newList);
    }

    private void setNewRecycler(List<New> newList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        newRecycler = findViewById(R.id.newsRecycler);
        newRecycler.setLayoutManager(layoutManager);

        newAdapter = new NewAdapter(this, newList);
        newRecycler.setAdapter(newAdapter);
    }

    public void init(){
        main = findViewById(R.id.main);
        news = findViewById(R.id.news);
        profile = findViewById(R.id.profile);
    }

    public void goMain(View view){
        startActivity(new Intent(NewsActivity.this, MainActivity.class));
    }

    public void goProfile(View view){
        startActivity(new Intent(NewsActivity.this, ProfileActivity.class));
    }

}