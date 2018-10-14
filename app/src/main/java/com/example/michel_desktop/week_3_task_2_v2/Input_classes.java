package com.example.michel_desktop.week_3_task_2_v2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Input_classes extends AppCompatActivity {

    TextInputEditText title;
    TextInputEditText inputUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_layout);

        inputUrl = findViewById(R.id.url_input);
        title = findViewById(R.id.title_id_input);

        //save button
        Button button = findViewById(R.id.sazve_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intendE = new Intent();
                StorgeModel SM = new StorgeModel(title.getText().toString(), inputUrl.getText().toString());
                intendE.putExtra("object", SM);
                setResult(RESULT_OK, intendE);
                finish();
            }
        });
    }
}
