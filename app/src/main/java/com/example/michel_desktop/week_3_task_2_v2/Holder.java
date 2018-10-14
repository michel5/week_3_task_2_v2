package com.example.michel_desktop.week_3_task_2_v2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

    public class Holder extends RecyclerView.ViewHolder {

        public TextView textView;
        public View view;

        /**
         *
         * @param itemView
         */
        public Holder(View itemView) {
            super(itemView);
            textView= itemView.findViewById(android.R.id.text1);
            view = itemView;
        }
    }

