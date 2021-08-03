package com.example.patternfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class searchResult extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<modelPattern> patternList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patterns_list);

        recyclerView = (RecyclerView) findViewById(R.id.pattern_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new RecyclerView.LayoutManager() {
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return null;
            }
        });

        patternList = new ArrayList<>();

        /** get data from Database
         *
         */

        for(int i=0; i < 10; i++){
            modelPattern mp = new modelPattern("A10000", "1,4,9,16,25,36,49,64,81,100","(n ^ 2)");
            patternList.add(mp);
        }

        adapter = new PatternAdapter(patternList);
        recyclerView.setAdapter(adapter);
    }
}