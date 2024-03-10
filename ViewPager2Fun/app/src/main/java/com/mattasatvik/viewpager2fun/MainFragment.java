package com.mattasatvik.viewpager2fun;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainFragment extends Fragment{
    ViewPager2 mViewPager2;
    int position;
    public static Fragment newInstance(ViewPager2 mViewPager2, int position) {
        MainFragment fragment = new MainFragment();
        fragment.mViewPager2 = mViewPager2;
        fragment.position=position;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = view.findViewById(R.id.image);
        if (position==0){
            imageView.setImageResource(R.drawable.shot1);
        }
        else if(position==1){
            imageView.setImageResource(R.drawable.shot2);
        }
        else if(position==2){
            imageView.setImageResource(R.drawable.shot3);
        }
        else if(position==3){
            imageView.setImageResource(R.drawable.shot4);
        }
        else if(position==4){
            imageView.setImageResource(R.drawable.shot5);
        }
        else{
            imageView.setImageResource(R.drawable.shot5);
        }
        TabLayout tabLayout = getActivity().findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, mViewPager2, (tab,position) -> tab.setText("Image " + (position+1))).attach();

    }
}
