package com.mattasatvik.fragmentsfun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    int count  = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction ft =getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment_container, Fragment.newInstance(1), "Fragment");
        ft.commit();

    }

    public void update_photo(View view) {
        Fragment fragmentB = (Fragment)getSupportFragmentManager().findFragmentByTag("Fragment");
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.animator.slide_up,R.animator.slide_down);
        count+=1;
        if(count > 4){
            count = 1;
        }
        ft.replace(R.id.fragment_container, Fragment.newInstance(count), "Fragment");
        ft.commit();
    }
}