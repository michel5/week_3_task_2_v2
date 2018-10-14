package com.example.michel_desktop.week_3_task_2_v2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class recAdapter extends  RecyclerView.Adapter<recAdapter.Holder> {

    private List<StorgeModel> listStorgeModel;


    private Context context;
    public List<StorgeModel> listNameObject;

    public recAdapter(Context context, List<StorgeModel> PortalObject) {
        this.context = context;
        this.listNameObject = PortalObject;

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cell, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        // Gets a single item in the list from its position
        final StorgeModel object = listNameObject.get(position);
        // The holder argument is used to reference the views inside the viewHolder
        // Populate the views with the data from the list
        holder.text.setText(object.getTEXT());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, WebVieuwController.class);
                intent.putExtra("url", object.getURL());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listNameObject.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        public TextView text;
        public View view;

        public Holder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text1);
            //geoImage = itemView.findViewById(R.id.geoImageView);
            view = itemView;

        }
    }
}
