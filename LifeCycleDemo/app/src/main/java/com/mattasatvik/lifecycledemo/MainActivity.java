package com.mattasatvik.lifecycledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    String TAG = "com.mattasatvik.layouts.layoutscycledemo";
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    LifecycleData current, life;
    TextView currentRun, lifetime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = getSharedPreferences(TAG,MODE_PRIVATE);
        editor = prefs.edit();
        current = new LifecycleData();
        current.duration = "Current Run";
        String lifecycleDataAsString = prefs.getString("lifetime","");
        if(lifecycleDataAsString.equals("")){
            life = new LifecycleData();
            life.duration = "Lifetime";
        }
        else{
            life = LifecycleData.parseJSON(lifecycleDataAsString);
        }
        lifetime = findViewById(R.id.lifet);
        currentRun = findViewById(R.id.current);
        String currentEnclosingMethod = new Throwable().getStackTrace()[0].getMethodName();
        current.updateEvent(currentEnclosingMethod);
        life.updateEvent(currentEnclosingMethod);
        displayData();


    }
    public void storeData(){
        editor.putString("lifetime",life.toJSON()).apply();
    }
    public void displayData(){
        lifetime.setText(life.toString());
        currentRun.setText(current.toString());
    }
    public void updateCount(String currentD){
        current.updateEvent(currentD);
        life.updateEvent(currentD);
        displayData();
        storeData();
    }
    @Override
    protected void onStart() {
        super.onStart();
        String currentEnclosingMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        updateCount(currentEnclosingMethod);
    }
    @Override
    protected void onResume(){
        super.onResume();
        String currentEnclosingMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        updateCount(currentEnclosingMethod);
    }
    @Override
    protected void onPause(){
        super.onPause();
        String currentEnclosingMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        updateCount(currentEnclosingMethod);
    }
    @Override
    protected void onStop(){
        super.onStop();
        String currentEnclosingMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        updateCount(currentEnclosingMethod);
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        String currentEnclosingMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        updateCount(currentEnclosingMethod);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        String currentEnclosingMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        updateCount(currentEnclosingMethod);
    }
}