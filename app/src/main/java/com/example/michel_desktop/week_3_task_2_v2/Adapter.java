package com.example.michel_desktop.week_3_task_2_v2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class mAdapter extends RecyclerView.Adapter<mAdapter.Holder>{

    private Context context;
    private List<StorgeModel> listStorgeModel;


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class Holder extends RecyclerView.ViewHolder {

        public TextView textView;
        public View view;

        public Holder(View itemView) {
            super(itemView);
            textView= itemView.findViewById(android.R.id.text1);
            view = itemView;
        }
    }
}
