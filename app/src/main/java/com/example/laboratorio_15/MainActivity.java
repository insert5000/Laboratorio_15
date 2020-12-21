package com.example.laboratorio_15;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private static String DIRECTION
            = "https://derian-android.netlify.app/";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        WebView webView = (WebView)findViewById(R.id.webView);
        ConstraintLayout v = findViewById(R.id.layout_webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.addJavascriptInterface(new WebAppInterface(this,v),"Android");
        webView.setWebViewClient(new MyWebViewClient());
        webView.loadUrl(DIRECTION);


    }




    private class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        WebView webView = (WebView)findViewById(R.id.webView);
        if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }




}