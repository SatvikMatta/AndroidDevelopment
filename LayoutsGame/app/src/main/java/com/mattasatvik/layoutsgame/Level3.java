package com.mattasatvik.layoutsgame;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class Level3 extends Activity {
    Button but;
    String TAG = "com.mattasatvik.layoutsgame.sharedprefs";
    SharedPreferences.Editor editor;
    String levelname = "level3";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level3);
        SharedPreferences sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        if(!sharedPreferences.getString("levelname", "level3").equals(levelname)) {
//            Log.println(Log.ASSERT,"hi",sharedPreferences.getString("levelname", "level3"));
            Intent intent = new Intent(getApplicationContext(), Level4.class);
            startActivity(intent);
        }
        but = findViewById(R.id.cont);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Level4.class);
                startActivity(intent);
                editor.putString("levelname", "level4").apply();
            }
        });
    }
}
