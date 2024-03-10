package com.mattasatvik.sprites;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawView extends View {
    Sprite sprite = new Sprite();
    Paint paint = new Paint();
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        sprite = new Sprite();
        sprite.grow(100);
        sprite.setBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.cape));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.WHITE);
        canvas.drawRect(getLeft(),0,getRight(),getBottom(),paint);
        paint.setColor(Color.RED);
        //sprite updates itself
        sprite.update(canvas);
        //sprite draws itself
        sprite.draw(canvas);
        invalidate();  //redraws screen, invokes onDraw()
    }
    public Sprite getSprite() {
        return sprite;
    }
}
