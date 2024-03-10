package com.mattasatvik.fragmentsfun;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Fragment extends androidx.fragment.app.Fragment {
    View view;
    public static Fragment newInstance(int x){
        Fragment fragment = new Fragment();
        Bundle args = new Bundle();
        args.putInt("Shot", x);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        ImageView imageView = view.findViewById(R.id.shot);
        TextView desc = view.findViewById(R.id.desc);
        int shot = getArguments().getInt("Shot",1);
        if (shot == 1){
            imageView.setImageResource(R.drawable.shot1);
            desc.setText(R.string.caverns);
        }
        else if(shot == 2){
            imageView.setImageResource(R.drawable.shot2);
            desc.setText(R.string.lake);
        }
        else if(shot == 3){
            imageView.setImageResource(R.drawable.shot3);
            desc.setText(R.string.deer);
        }
        else{
            imageView.setImageResource(R.drawable.shot4);
            desc.setText(R.string.waterfall);
        }
    }
}
