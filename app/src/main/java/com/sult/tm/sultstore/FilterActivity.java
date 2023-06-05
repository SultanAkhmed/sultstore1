package com.sult.tm.sultstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.sult.tm.sultstore.model.Check;

public class FilterActivity extends AppCompatActivity {

    CardView compRect, noteRect, gameRect;
    EditText priceTextFrom, priceTextTo;
    Integer priceFromS, priceToS;
    TextView accept;
    @SuppressLint("StaticFieldLeak")
    static TextView onAccept;
    static Integer priceFrom, priceTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        init();
        onAccept = accept;

        if (Check.checkFilter[0]) {
            compRect.setCardBackgroundColor(Color.parseColor("white"));
            noteRect.setCardBackgroundColor(Color.parseColor("grey"));
            gameRect.setCardBackgroundColor(Color.parseColor("grey"));
        }
        if (Check.checkFilter[1]) {
            compRect.setCardBackgroundColor(Color.parseColor("grey"));
            noteRect.setCardBackgroundColor(Color.parseColor("white"));
            gameRect.setCardBackgroundColor(Color.parseColor("grey"));
        }
        if (Check.checkFilter[2]) {
            compRect.setCardBackgroundColor(Color.parseColor("grey"));
            noteRect.setCardBackgroundColor(Color.parseColor("grey"));
            gameRect.setCardBackgroundColor(Color.parseColor("white"));
        }
    }

    public void init(){
        compRect = findViewById(R.id.cardComp);
        noteRect = findViewById(R.id.cardNote);
        gameRect = findViewById(R.id.cardGame);

        priceTextFrom = findViewById(R.id.price_text_from);
        priceTextTo = findViewById(R.id.price_text_to);
        accept = findViewById(R.id.filter_accept);
    }

    public void goBack(View view){
        startActivity(new Intent(FilterActivity.this, SearchActivity.class));
    }

    public void onComp(View view) {
        compRect.setCardBackgroundColor(Color.parseColor("white"));
        noteRect.setCardBackgroundColor(Color.parseColor("grey"));
        gameRect.setCardBackgroundColor(Color.parseColor("grey"));

        Check.checkFilter[0] = true;
        Check.checkFilter[1] = false;
        Check.checkFilter[2] = false;
    }

    public void onNote(View view){
        compRect.setCardBackgroundColor(Color.parseColor("grey"));
        noteRect.setCardBackgroundColor(Color.parseColor("white"));
        gameRect.setCardBackgroundColor(Color.parseColor("grey"));

        Check.checkFilter[0] = false;
        Check.checkFilter[1] = true;
        Check.checkFilter[2] = false;
    }

    public void onGame(View view){
        compRect.setCardBackgroundColor(Color.parseColor("grey"));
        noteRect.setCardBackgroundColor(Color.parseColor("grey"));
        gameRect.setCardBackgroundColor(Color.parseColor("white"));

        Check.checkFilter[0] = false;
        Check.checkFilter[1] = false;
        Check.checkFilter[2] = true;
    }

    public void reset(View view) {
        compRect.setCardBackgroundColor(Color.parseColor("#DDDDDD"));
        noteRect.setCardBackgroundColor(Color.parseColor("#DDDDDD"));
        gameRect.setCardBackgroundColor(Color.parseColor("#DDDDDD"));

        Check.checkFilter[0] = false;
        Check.checkFilter[1] = false;
        Check.checkFilter[2] = false;

        priceTextFrom.setText("");
        priceTextTo.setText("");
    }

    public void goAccept(View view) {

        if (!priceTextFrom.getText().toString().equals("")) {
            priceFromS = Integer.parseInt(priceTextFrom.getText().toString());
            priceFrom = priceFromS;
            SearchActivity.checkPriceFrom = true;
        }

        if (!priceTextTo.getText().toString().equals("")) {
            priceToS = Integer.parseInt(priceTextFrom.getText().toString());
            priceTo = priceToS;
            SearchActivity.checkPriceTo = true;
        }

        startActivity(new Intent(FilterActivity.this, SearchActivity.class));
    }
}