package com.example.patternfinder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PatternAdapter extends RecyclerView.Adapter<PatternAdapter.PatternViewHolder> {

    private List<modelPattern> patternList;
    //Context context;

    public class PatternViewHolder extends RecyclerView.ViewHolder {
        public TextView id, pattern, formula;

        public PatternViewHolder(View view) {
            super(view);
            id = (TextView) view.findViewById(R.id.patternID);
            pattern = (TextView) view.findViewById(R.id.pattern);
            formula = (TextView) view.findViewById(R.id.formula);
        }
    }

    public PatternAdapter(List<modelPattern> list){
        this.patternList = list;
    }

    /*public PatternAdapter(List<modelPattern> mylist, Context context) {
        this.mylist = mylist;
        this.context = context;
    }*/

    @NonNull
    public PatternViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.patterns_list, parent, false);

        return new PatternViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PatternViewHolder holder, int position) {
        modelPattern mp = patternList.get(position);

        holder.id.setText(mp.getPatternID());
        holder.pattern.setText(mp.getPattern());
        holder.formula.setText(mp.getFormula());
    }

    @Override
    public int getItemCount() {
        return patternList.size();
    }


}