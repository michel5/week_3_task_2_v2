package com.example.michel_desktop.week_3_task_2_v2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<StorgeModel> mList = new ArrayList<>();
    private Button vloButton;
    private Button DMCIButton;
    private Button roosterButton;
    private recAdapter mAdapter;
    private RecyclerView mPortalRecyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


         mPortalRecyclerView = findViewById(R.id.reclc_id);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        mPortalRecyclerView.setLayoutManager(mLayoutManager);
       mAdapter = new recAdapter(this, mList);
        mPortalRecyclerView.setAdapter(mAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newPortaal();
           }
        });

        vloButton = findViewById(R.id.vlo_id);
        vloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WebVieuwController.class);
                intent.putExtra("url", "https://vlo.informatica.hva.nl/");
                startActivity(intent);
            }
        });

        DMCIButton = findViewById(R.id.dcmi_id);
        DMCIButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WebVieuwController.class);
                intent.putExtra("url", "http://www.hva.nl/faculteit/fdmci/onderwijs/mci-onderwijs.html");
                startActivity(intent);
            }
        });

        roosterButton = findViewById(R.id.rooster_id);
        roosterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WebVieuwController.class);
                intent.putExtra("url", "https://rooster.hva.nl/");
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void newPortaal(){
        Intent intent = new Intent(this, Input_classes.class);
        startActivityForResult(intent, 6969);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 6969){
            if(resultCode == RESULT_OK){
                mList.add((StorgeModel)data.getSerializableExtra("object"));
                StorgeModel SM = mList.get(0);
                String l = SM.getTEXT();
                String f = SM.getURL();

                Log.w("test", ""+mList.size());
                mAdapter.notifyDataSetChanged();
            }
        }
    }

}
