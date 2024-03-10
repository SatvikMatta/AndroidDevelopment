package com.mattasatvik.lifecyclefun;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView videoview;
    MediaController mediaController;
    MediaPlayer mp;
    int stopPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Res0", "onCreate called");
        setContentView(R.layout.activity_main);
        videoview  = (VideoView) findViewById(R.id.videoView);
        videoview.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.vidioclip);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoview);
        videoview.setMediaController(mediaController);
        videoview.start();
    }
    @Override
    public void onResume() {

        super.onResume();
        videoview.seekTo(stopPosition);
        Log.d("Res0","onResume called");
        videoview.resume();
        videoview.start();
    }

    @Override
    public void onPause() {

        super.onPause();
        stopPosition = videoview.getCurrentPosition();
        Log.d("Res0","onPause called");
        videoview.pause();

    }
}