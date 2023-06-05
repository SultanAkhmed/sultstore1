package com.sult.tm.sultstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NewsPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_page);

        TextView newsTitle = findViewById(R.id.newsTitle);
        TextView newsDesc = findViewById(R.id.newsDesc);
        TextView newsText = findViewById(R.id.newsText);

        newsTitle.setText(getIntent().getStringExtra("newsTitle"));
        newsDesc.setText(getIntent().getStringExtra("newsDesc"));
        newsText.setText(getIntent().getStringExtra("newsText"));
    }

    public void goLook(View view){
        startActivity(new Intent(NewsPageActivity.this, SearchActivity.class));
    }

}