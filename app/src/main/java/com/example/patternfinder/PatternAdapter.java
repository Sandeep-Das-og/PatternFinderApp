package com.example.patternfinder;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PatternAdapter extends RecyclerView.Adapter<PatternAdapter.PatternViewHolder> {

    private List<modelPattern> patternList;


    @NonNull
    @Override
    public PatternAdapter.PatternViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i("Location :", "Inside Pattern View Holder");

//        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.example_patternview, parent, false);
//        Log.i("Location :", "Inside Pattern View Holder");
//        return new PatternViewHolder(itemView);
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.example_patternview, parent, false);
        PatternViewHolder viewHolder = new PatternViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PatternViewHolder holder, int position) {
        modelPattern mp = patternList.get(position);

        holder.id.setText(mp.getPatternID());
        holder.pattern.setText(mp.getPattern());
        holder.formula.setText(mp.getFormula());
        holder.description.setText(mp.getName());
    }

    @Override
    public int getItemCount() {
        return patternList.size();
    }
    //Context context;

    public class PatternViewHolder extends RecyclerView.ViewHolder {
        public TextView id, pattern, formula, description;

        public PatternViewHolder(View view) {
            super(view);
            id = (TextView) view.findViewById(R.id.patternID);
            pattern = (TextView) view.findViewById(R.id.pattern);
            formula = (TextView) view.findViewById(R.id.formula);
            description = (TextView) view.findViewById(R.id.Description);
        }
    }

    public PatternAdapter(List<modelPattern> list) {
        this.patternList = list;
        Log.i("LOCATION ->", "PatternAdapter: Constructor");
    }

    /*public PatternAdapter(List<modelPattern> mylist, Context context) {
        this.mylist = mylist;
        this.context = context;
    }*/


//    @NonNull
//    public PatternViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Log.i("Location :", "Inside Pattern View Holder");
////        View itemView = LayoutInflater.from(parent.getContext())
////                .inflate(R.layout.example_patternview, parent, false);
////        Log.i("Location :", "Inside Pattern View Holder");
////        return new PatternViewHolder(itemView);
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        View listItem= layoutInflater.inflate(R.layout.example_patternview, parent, false);
//        PatternViewHolder viewHolder = new PatternViewHolder(listItem);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull PatternViewHolder holder, int position) {
//        modelPattern mp = patternList.get(position);
//
//        holder.id.setText(mp.getPatternID());
//        holder.pattern.setText(mp.getPattern());
//        holder.formula.setText(mp.getFormula());
//        holder.description.setText(mp.getName());
//    }
//
//    @Override
//    public int getItemCount() {
//        return patternList.size();
//    }


}