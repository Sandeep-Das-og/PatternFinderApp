package com.example.patternfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //new Manager( MainActivity.this);
        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button search = (Button) findViewById(R.id.search_button);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchPattern();
            }
        });
    }

    private void SearchPattern() {
        Button search = (Button) findViewById(R.id.search_button);
        search.setBackgroundColor(Color.parseColor("#EF5D30"));
        Intent intent = new Intent(MainActivity.this, searchResult.class);
        startActivity(intent);
    }
}