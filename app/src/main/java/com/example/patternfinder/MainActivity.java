package com.example.patternfinder;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

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
        final DBHelper DB=new DBHelper(this);
        search.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                SearchPattern(DB);
            }
        });



    }

    private void SearchPattern(DBHelper DB) {
        Button search = (Button) findViewById(R.id.search_button);
        EditText value=(EditText) findViewById(R.id.search);

        search.setBackgroundColor(Color.parseColor("#EF5D30"));

        Intent intent = new Intent(MainActivity.this, searchResult.class);
        intent.putExtra("query",value.getText().toString());

        startActivity(intent);
    }
}

//        Manager mgr = new Manager(this);
//        try{
//           Pair<String, JSONObject> pa=mgr.searchData("123");
//            Log.i("RESULT KEY ",pa.first());
//
//        }
//        catch(Exception e){}
