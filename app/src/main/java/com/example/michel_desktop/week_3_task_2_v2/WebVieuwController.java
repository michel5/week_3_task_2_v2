package com.example.michel_desktop.week_3_task_2_v2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class WebVieuwController extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_vieuw_layout);

        //krijg de back button
        button = findViewById(R.id.back_id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //krijg intent
        Intent intent = getIntent();

        //web vieuw
        WebView myWebView = (WebView) findViewById(R.id.web_vieuw_id);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.getSettings().setJavaScriptEnabled(true);
        System.out.println("testje");
        Log.i("url", "blablabalabala "+intent.getStringExtra("url"));
        myWebView.loadUrl(intent.getStringExtra("url"));
        //myWebView.loadUrl("https://vlo.informatica.hva.nl/");

    }
}
