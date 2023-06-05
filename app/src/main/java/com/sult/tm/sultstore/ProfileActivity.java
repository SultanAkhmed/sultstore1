package com.sult.tm.sultstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {

    ImageView main, news, profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        init();
    }

    public void init(){
        main = findViewById(R.id.main);
        news = findViewById(R.id.news);
        profile = findViewById(R.id.profile);
    }

    public void goNews(View view){
        startActivity(new Intent(ProfileActivity.this, NewsActivity.class));
    }

    public void goMain(View view){
        startActivity(new Intent(ProfileActivity.this, MainActivity.class));
    }

    public void goCart(View view){
        startActivity(new Intent(ProfileActivity.this, CartActivity.class));
    }
    public void goFavourites(View view){
        startActivity(new Intent(ProfileActivity.this, FavouritesActivity.class));
    }
}