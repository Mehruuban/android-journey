package com.mehru.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class webView extends AppCompatActivity {

    Toolbar toolbar;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_web_view);


        toolbar = findViewById(R.id.toolbar);
        webView= findViewById(R.id.webView);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        String url = "Url";
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }
}