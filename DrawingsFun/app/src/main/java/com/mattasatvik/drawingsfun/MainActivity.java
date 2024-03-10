package com.mattasatvik.drawingsfun;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.google.android.material.slider.Slider;

public class MainActivity extends AppCompatActivity {

    Button increase, decrease;
    DrawView drawView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawView = findViewById(R.id.drawView);
        increase = findViewById(R.id.Add);
        increase.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                AddSmile();
                return false;
            }
        });
        decrease = findViewById(R.id.Decrease);
        decrease.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                DecreaseSmile();
                return false;
            }
        });
    }

    public void reverseY(View view) {
    }

    public void AddSmile() {
        drawView.add();
    }
    public void DecreaseSmile() {
        drawView.decrease();
    }

    public void KillAll(View view) {
        drawView.killAll();
    }
}