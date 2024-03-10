package com.mattasatvik.sprites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void moveLeft(View view) {
        // Get the DrawView object
        DrawView drawView = findViewById(R.id.draw_view);
        // Get the sprite from the DrawView
        Sprite sprite = drawView.getSprite();
        // Set the sprite's dX value to a negative number to move it left
        sprite.setdX(-10);
        // Set the sprite's dY value to 0 to keep it moving horizontally
        sprite.setdY(0);
        // Invalidate the view to redraw it
        drawView.invalidate();
    }

    public void moveDown(View view) {
        DrawView drawView = findViewById(R.id.draw_view);
        Sprite sprite = drawView.getSprite();
        // Set the sprite's dX value to 0 to keep it moving vertically
        sprite.setdX(0);
        // Set the sprite's dY value to a positive number to move it down
        sprite.setdY(10);
        drawView.invalidate();
    }

    public void moveUp(View view) {
        DrawView drawView = findViewById(R.id.draw_view);
        Sprite sprite = drawView.getSprite();
        sprite.setdX(0);
        // Set the sprite's dY value to a negative number to move it up
        sprite.setdY(-10);
        drawView.invalidate();
    }

    public void moveRight(View view) {
        DrawView drawView = findViewById(R.id.draw_view);
        Sprite sprite = drawView.getSprite();
        // Set the sprite's dX value to a positive number to move it right
        sprite.setdX(10);
        sprite.setdY(0);
        drawView.invalidate();
    }
}