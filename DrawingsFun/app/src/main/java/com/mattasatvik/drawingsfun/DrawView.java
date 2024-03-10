package com.mattasatvik.drawingsfun;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Random;

public class DrawView extends View {
    private Paint p = new Paint();
    private int y =0, dY=5;
    ArrayList<SmallSmiles> ss = new ArrayList<SmallSmiles>();
    int num = 3;
    boolean fix = true;
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(ss.size() < num){
            ss.add(new SmallSmiles(getWidth()/2-105/2,(getHeight()/2+45),new Paint(),canvas, new Random().nextInt(10)+1,new Random().nextInt(10)+1));
        }
        while (num < ss.size()){
            ss.get(ss.size()-1).destroy(canvas);
            ss.remove(ss.size()-1);
        }
        p.setColor(Color.BLACK);
        canvas.drawCircle(getWidth()/2-100,getHeight()/2-100,50,p);
        canvas.drawCircle(getWidth()/2+100,getHeight()/2-100,50,p);
        canvas.drawCircle(getWidth()/2,getHeight()/2+75,75,p);
        canvas.drawCircle(getWidth()/2,getHeight()/2,310,p);
        p.setColor(Color.YELLOW);
        canvas.drawCircle(getWidth()/2,getHeight()/2,300,p);
        p.setColor(Color.BLACK);
        canvas.drawCircle(getWidth()/2-100,getHeight()/2-100,50,p);
        canvas.drawCircle(getWidth()/2+100,getHeight()/2-100,50,p);
        canvas.drawCircle(getWidth()/2,getHeight()/2+75,75,p);
        p.setColor(Color.WHITE);
        canvas.drawCircle(getWidth()/2-100,getHeight()/2-100,20,p);
        canvas.drawCircle(getWidth()/2+100,getHeight()/2-100,20,p);
        p.setColor(Color.parseColor("#FFC0CB"));
        canvas.drawCircle(getWidth()/2,getHeight()/2+75,50,p);
        for(int i = 0; i<ss.size(); i++){
            ss.get(i).update(canvas);
            ss.get(i).draw(canvas);
           // canvas.drawRect(ss.get(i),new Paint());
        }
        //canvas.drawCircle(540,1040,500,new Paint());
        invalidate();
    }

    public int getdY() {
        return dY;
    }

    public void setdY(int dY) {
        this.dY = dY;
    }

    public void add(){
        this.num+=1;
    }
    public void decrease(){
        this.num-=1;
        if (this.num < 0){
            this.num = 0;
        }
    }

    public void killAll() {
        this.num = 0;
    }
}
