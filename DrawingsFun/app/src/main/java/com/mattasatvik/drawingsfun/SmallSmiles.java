package com.mattasatvik.drawingsfun;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class SmallSmiles extends RectF {
    //int width,height;
    Paint p;
    Canvas canvas;
    int y;
    int x;
    int dY;
    int dX;
    public SmallSmiles(int x, int y,Paint p, Canvas c, int dY, int dX) {
        super(x,y,x+105,y+105);
//        this.x = x;
//        this.y = y;
        this.p = p;
        this.canvas =c;
        this.dY = dY;
        this.dX = dX;

//        width=c.getWidth();
//        height=c.getHeight();
//
    }
    public SmallSmiles(int x, int y,Paint p, Canvas c, int dY) {
        super(x,y,x,y);
        this.x = x;
        this.y = y;
        this.p = p;
        this.canvas =c;
        this.dY = dY;
        this.dX = 0;

//        width=c.getWidth();
//        height=c.getHeight();
//
    }
    public SmallSmiles(int x, int y,Paint p, Canvas c) {
        super(x,y,x,y);
        this.x = x;
        this.y = y;
        this.p = p;
        this.canvas =c;
        this.dY = 0;
//
    }
    public void update(Canvas canvas){
        if(canvas.getHeight() < bottom+dY){
            this.dY *= -1;
        }
        else if(0 > left+dX){
            this.dX *= -1;
        }
        if(canvas.getWidth() < right+dX){
            this.dX *= -1;
        }
        else if(0 > top+dX){
            this.dY *= -1;
        }
        offset(dX,dY);
    }
    public void draw(Canvas canvas){
        p.setColor(Color.BLACK);
        canvas.drawCircle(centerX(),centerY(),105,p);
        p.setColor(Color.YELLOW);
        canvas.drawCircle(centerX(),centerY(),100,p);
        p.setColor(Color.BLACK);
        canvas.drawCircle(centerX()- 33,centerY()-50, 16,p);
        canvas.drawCircle(centerX()+33,centerY()-50, 16,p);
        canvas.drawCircle(centerX(),centerY()+25, 25,p);
        p.setColor(Color.WHITE);
        canvas.drawCircle(centerX()- 33,centerY()-50, 7,p);
        canvas.drawCircle(centerX()+33,centerY()-50, 7,p);
        p.setColor(Color.parseColor("#FFC0CB"));
        canvas.drawCircle(centerX(),centerY()+25, 16,p);
    }
    public void destroy(Canvas canvas){
        offset(20000,20000);
        p.setColor(Color.WHITE);
        dX = 0;
        dY = 0;
        canvas.drawCircle(centerX(),centerY(),200, p);
    }

}
