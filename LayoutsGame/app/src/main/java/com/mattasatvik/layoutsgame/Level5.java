package com.mattasatvik.layoutsgame;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class Level5 extends Activity {
    Button but;
    String TAG = "com.mattasatvik.layoutsgame.sharedprefs";
    SharedPreferences.Editor editor;
    int dest;
    String levelname = "level5";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level5);
        SharedPreferences sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        but = findViewById(R.id.cont);

        if(!sharedPreferences.getString("levelname", "level5").equals(levelname)) {
            Intent intent = new Intent(getApplicationContext(), Fini.class);
            startActivity(intent);
        }
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sharedPreferences.getInt("destroycount",0)>5) {
                    Intent intent = new Intent(getApplicationContext(), Fini.class);
                    startActivity(intent);
                    editor.putString("levelname", "fini").apply();
                    editor.putInt("destroycount",0).apply();
                }
                else{
                    Log.println(Log.ASSERT, "destcount", ""+sharedPreferences.getInt("destroycount",0));
                }
            }
        });
    }

//    @Override
//    protected void onDestroy() {
//        SharedPreferences sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
//        editor = sharedPreferences.edit();
//        int d = sharedPreferences.getInt("destroycount", 0);
//        editor.putInt("destroycount",d+1).apply();
//        super.onDestroy();
//    }
}
