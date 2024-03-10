package com.mattasatvik.sharedprefsfun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String TAG = "com.mattasatvik.sharedprefrences.sharedprefsfun";
    TextView mode, hscore;
    Button tleft, tright, bleft, bright, start;
    SeekBar seekBar;
    ConstraintLayout layout;
    TextView views[];
    int count;
    long starttime;
    int n;
    boolean play;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mode = findViewById(R.id.mode);
        hscore = findViewById(R.id.high);
        tleft = findViewById(R.id.topleft_button);
        tright = findViewById(R.id.topright_button);
        bleft = findViewById(R.id.botleft_button);
        bright = findViewById(R.id.botright_button);
        start = findViewById(R.id.centerbutton);
        seekBar = findViewById(R.id.seekbar);
        layout = findViewById(R.id.activitymain);
        bleft.setOnClickListener(this);
        bright.setOnClickListener(this);
        tleft.setOnClickListener(this);
        tright.setOnClickListener(this);
        views = new TextView[]{tleft, tright, bleft, bright};
        count = 0;
        sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        play = false;
        n=2;
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int lastProgress;

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                n = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {//record state
                lastProgress = seekBar.getProgress();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {//pop snackbar
                Snackbar snackbar = Snackbar.make(layout, "Mode Changed To: " + seekBar.getProgress(), Snackbar.LENGTH_LONG);
                snackbar.setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        seekBar.setProgress(lastProgress);
                        Snackbar.make(layout, "Mode Changed To: " + lastProgress, Snackbar.LENGTH_LONG);
                    }
                });
                mode.setText("Mode: " + seekBar.getProgress());
                editor.putString(seekBar.getTag().toString(),""+seekBar.getProgress()).apply();
                snackbar.show();
            }

        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!start.getText().equals("Reset")) {
                    start.setText("Reset");
                    starttime = System.currentTimeMillis();
                    play = true;
                    if (n == 1) {
                        bleft.setText("Right");
                        bright.setText("Wrong");
                        tleft.setText("Wrong");
                        tright.setText("Wrong");
                        bleft.setBackgroundColor(Color.GREEN);
                        bright.setBackgroundColor(Color.RED);
                        tleft.setBackgroundColor(Color.RED);
                        tright.setBackgroundColor(Color.RED);
                    } else if (n == 2) {
                        bleft.setText("Right");
                        bright.setText("Right");
                        tleft.setText("Wrong");
                        tright.setText("Wrong");
                        bleft.setBackgroundColor(Color.GREEN);
                        bright.setBackgroundColor(Color.GREEN);
                        tleft.setBackgroundColor(Color.RED);
                        tright.setBackgroundColor(Color.RED);
                    } else if (n == 3) {
                        bleft.setText("Right");
                        bright.setText("Right");
                        tleft.setText("Wrong");
                        tright.setText("Right");
                        bleft.setBackgroundColor(Color.GREEN);
                        bright.setBackgroundColor(Color.GREEN);
                        tleft.setBackgroundColor(Color.RED);
                        tright.setBackgroundColor(Color.GREEN);
                    } else {
                        bleft.setText("Right");
                        bright.setText("Right");
                        tleft.setText("Right");
                        tright.setText("Right");
                        bleft.setBackgroundColor(Color.GREEN);
                        bright.setBackgroundColor(Color.GREEN);
                        tleft.setBackgroundColor(Color.GREEN);
                        tright.setBackgroundColor(Color.GREEN);
                    }
                }
                else{
                    setInitialValue();
                    start.setText("PRESS TO START!");
                    reset();
                    play = false;
                }
            }

        });
        setInitialValue();

    }
    private void reset(){
        bleft.setBackgroundColor(Color.LTGRAY);
        bright.setBackgroundColor(Color.LTGRAY);
        tleft.setBackgroundColor(Color.LTGRAY);
        tright.setBackgroundColor(Color.LTGRAY);
    }
    private void setInitialValue() {
        for (TextView x: views) {
            x.setText("Click Start to Play!");
        }
        hscore.setText(sharedPreferences.getString(hscore.getTag().toString(),"Lowest Time: -1"));
        seekBar.setProgress(Integer.parseInt(sharedPreferences.getString(seekBar.getTag().toString(),"2")));
        mode.setText("Mode: " + seekBar.getProgress());
    }

    @Override
    public void onClick (View view){
        if(play) {
            TextView x = (TextView) view;
            x.setText("Clicked");
            x.setBackgroundColor(Color.BLACK);
            count++;
            if (count == n) {
                if (Integer.parseInt(hscore.getText().toString().split(": ")[1]) > (System.currentTimeMillis() - starttime) || Integer.parseInt(hscore.getText().toString().split(": ")[1]) == -1) {
                    hscore.setText("Lowest Time: " + (System.currentTimeMillis() - starttime));
                    editor.putString(hscore.getTag().toString(), hscore.getText().toString()).apply();
                }
            }
        }
    }

}

