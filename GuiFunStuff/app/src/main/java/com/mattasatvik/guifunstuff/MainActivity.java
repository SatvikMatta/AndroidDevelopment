package com.mattasatvik.guifunstuff;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText num1;
    EditText num2;
    TextView answer;
    RadioButton add, subtract, divide, multiply;
    Button calc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.number1);
        num2 = findViewById(R.id.number2);
        answer = findViewById(R.id.answer);
        add = findViewById(R.id.radio_add);
        subtract = findViewById(R.id.radio_sub);
        multiply = findViewById(R.id.radio_mult);
        divide = findViewById(R.id.radio_divide);
        calc = findViewById(R.id.calc);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean error = true;
                double result = 0.0;
                double n1 = 0.0;
                double n2 = 0.0;
                if (num1.getText().toString().length() > 0 && num2.getText().toString().length() > 0){
                    try{
                        n1 = Double.parseDouble(num1.getText().toString());
                        n2 = Double.parseDouble(num2.getText().toString());
                        error = false;
                    }
                    catch (Exception e){
                        error = true;
                    }

                    if (divide.isChecked()){
                        if(n2 != 0){
                            result = n1/n2;
                        }
                        else{
                            error = true;
                        }
                    }
                    else if(subtract.isChecked()){
                        result = n1-n2;
                    }
                    else if(multiply.isChecked()){
                        result = n1*n2;
                    }
                    else {
                        result = n1 + n2;
                    }
                }
                if(!error){
//                    int temp = Integer.parseInt(""+result);
//                    if(temp == result){
//                        answer.setText(format("%d", temp));
//                    }
//                    else{
//                        answer.setText(format("%s", result));
//                    }
                    answer.setText(String.format("%s", result));
                }
                else{
                    answer.setText(R.string.error);
                }
            }
        });

    }
}