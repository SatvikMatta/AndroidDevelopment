package com.mattasatvik.layoutsgame;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class Level4 extends Activity {
    Button but;
    String TAG = "com.mattasatvik.layoutsgame.sharedprefs";
    SharedPreferences.Editor editor;
    String levelname = "level4";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level4);
        SharedPreferences sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        but = findViewById(R.id.cont);
        if(!sharedPreferences.getString("levelname", "level4").equals(levelname)) {
            Intent intent = new Intent(getApplicationContext(), Level5.class);
            startActivity(intent);
        }
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Level5.class);
                startActivity(intent);
                editor.putString("levelname", "level5").apply();
            }
        });
    }
}
