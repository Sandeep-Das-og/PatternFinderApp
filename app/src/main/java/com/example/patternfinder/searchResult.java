package com.example.patternfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class searchResult extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PatternAdapter adapter;
    private List<modelPattern> patternList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patterns_list);

        recyclerView = (RecyclerView) findViewById(R.id.pattern_recyclerview);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new RecyclerView.LayoutManager() {
//            @Override
//            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
//                return null;
//            }
//        });

        patternList = new ArrayList<>();
        Intent intent = getIntent();
        String value = intent.getStringExtra("query");

        DBHelper DB=new DBHelper(this);
        Cursor cursor=DB.SearchData(value);
        cursor.moveToFirst();
        int id=cursor.getColumnIndex("id");
        int name=cursor.getColumnIndex("name");
        int pattern=cursor.getColumnIndex("pattern");
        int formula=cursor.getColumnIndex("formula");
        Log.i("LOCATION ->", "I am In Search Result");

        while (!cursor.isAfterLast()){
            String elem_id=cursor.getString(id);
            String elem_name=cursor.getString(name);
            String elem_pattern=cursor.getString(pattern);
            String elem_formula=cursor.getString(formula);
            modelPattern mp = new modelPattern(elem_id,elem_pattern,elem_formula,elem_name);
            patternList.add(mp);

            cursor.moveToNext();

        }

        Log.i("Size Got", " "+patternList.size());

//        adapter = new PatternAdapter(patternList);
//        recyclerView.setAdapter(adapter);

        adapter = new PatternAdapter(patternList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}