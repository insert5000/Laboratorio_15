package com.example.laboratorio_15;

import android.content.Context;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class WebAppInterface {
    Context context;
    View view;

    WebAppInterface(Context c, View v){
        this.context = c;
        this.view = v;
    }

    @JavascriptInterface
    public void showToastMessage(String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void showSnackBar(String message){
        Snackbar.make(view,message,Snackbar.LENGTH_LONG).show();
    }
}

