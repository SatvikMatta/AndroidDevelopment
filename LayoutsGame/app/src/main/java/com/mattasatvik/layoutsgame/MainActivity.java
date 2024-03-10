package com.mattasatvik.layoutsgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button but ;
    String TAG = "com.mattasatvik.layoutsgame.sharedprefs";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String levelname = "main";
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        if(sharedPreferences.contains("levelname")){
            levelname = sharedPreferences.getString("levelname", levelname);
        }
        else{
            editor.putString("levelname", levelname);
        }
        if(levelname.equals("level1")) {
            Intent intent = new Intent(getApplicationContext(), Level1.class);
            startActivity(intent);
        }
        else if(levelname.equals("level2")){
            Intent intent = new Intent(getApplicationContext(), Level2.class);
            startActivity(intent);
        }
        setContentView(R.layout.activity_main);
        but = findViewById(R.id.cont);
//        but.setText(sharedPreferences.getString("levelname", "None"));
        sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count += 1;
                if(count >= 5){
                    Intent intent = new Intent(getApplicationContext(), Level1.class);
                    editor.putString("levelname", "level1").apply();
                    startActivity(intent);

                }
            }
        });
    }
}