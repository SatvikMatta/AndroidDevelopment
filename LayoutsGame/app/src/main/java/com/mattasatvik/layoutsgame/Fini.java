package com.mattasatvik.layoutsgame;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class Fini extends Activity {
    String TAG = "com.mattasatvik.layoutsgame.sharedprefs";
    SharedPreferences.Editor editor;
    String levelname = "fini";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fini);
        SharedPreferences sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("levelname", "main").apply();
    }
}
