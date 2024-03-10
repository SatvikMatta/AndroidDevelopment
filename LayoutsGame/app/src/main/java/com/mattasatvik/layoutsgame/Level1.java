package com.mattasatvik.layoutsgame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class Level1 extends Activity {
    Button but ;
    String TAG = "com.mattasatvik.layoutsgame.sharedprefs";
    SharedPreferences.Editor editor;
    String levelname = "level1";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if(!sharedPreferences.getString("levelname", "level1").equals(levelname)) {
//            Intent intent = new Intent(getApplicationContext(), Level2.class);
//            startActivity(intent);
//        }
        setContentView(R.layout.level1);
        SharedPreferences sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        if(!sharedPreferences.getString("levelname", "level1").equals(levelname)) {
            Intent intent = new Intent(getApplicationContext(), Level2.class);
            startActivity(intent);
        }
        but = findViewById(R.id.cont);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("levelname", "level2").apply();
                Intent intent = new Intent(getApplicationContext(), Level2.class);
                startActivity(intent);
            }
        });
    }
}
