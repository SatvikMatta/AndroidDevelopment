package com.mattasatvik.sprites;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public class Sprite extends RectF {
    private int dX, dY, color;
    private static final int BMP_COLUMS = 4;
    private static final int BMP_ROWS = 4;
    private static final int DOWN=0, LEFT = 1, RIGHT = 2, UP = 3;
    private Bitmap bitmap;
    private int currentFrame=0, iconWidth, iconHeight;
    public Sprite(float left, float top, float right, float bottom, int dX, int dY, int color) {
        super(left, top, right, bottom);
        this.dX = dX;
        this.dY = dY;
        this.color = color;
    }

    public Sprite(float left, float top, float right, float bottom) {
        this(left, top, right, bottom, 1,2, Color.MAGENTA);
    }

    public Sprite(int dX, int dY, int color) {
        this(100,100,210,210,dX,dY,color);
    }

    public Sprite() {
        this(0,0,Color.GREEN);
    }
//    public void update(Canvas canvas){
//        offsetTo(left,canvas.getHeight());
//        offset(dX,dY);
//    }

    public void update(Canvas canvas) {
        if (left + dX < 0 || right + dX > canvas.getWidth())//if next step hits boundary
            dX *= -1; //bounce off left and right boundaries
        if(top+dY>canvas.getHeight())//if next step puts off bottom of screen
            offsetTo(left, -height());//teleport to top of screen
        if (bottom+dY<0)
            offsetTo(left, canvas.getHeight());
        offset(dX, dY);//moves dx to the right and dY downwards
    }

    public void draw(Canvas canvas){
//        Paint paint = new Paint();
//        paint.setColor(color);
////        canvas.drawCircle(centerX(),centerY(),width()/2, paint);
        if(bitmap == null){
            Paint paint = new Paint();
            paint.setColor(color);
            canvas.drawCircle(centerX(),centerY(),width()/2, paint);
        }
        else{
            iconWidth = bitmap.getWidth()/BMP_COLUMS;
            iconHeight = bitmap.getHeight()/BMP_ROWS;
            int srcX = currentFrame * iconWidth;
            int srcY = getAnimationRow()*iconHeight;
            Rect src = new Rect(srcX,srcY,srcX+iconWidth, srcY+iconHeight);
            canvas.drawBitmap(bitmap,src,this,null);
        }
    }

    private int getAnimationRow(){
        if(Math.abs(dX)> Math.abs(dY)){
            if(Math.abs(dX)==dX) return RIGHT;
            else return LEFT;
        }
        else if(Math.abs(dY) == dY) return DOWN;
        else return UP;
    }

    public int getdX() {
        return dX;
    }

    public void setdX(int dX) {
        this.dX = dX;
    }

    public int getdY() {
        return dY;
    }

    public void setdY(int dY) {
        this.dY = dY;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void grow(int i) {
        right = right + i;
        bottom = bottom + i;
    }
}
