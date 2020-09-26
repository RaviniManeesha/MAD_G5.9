package com.example.attendancecriteria;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculate extends AppCompatActivity {

    private TextView textView;
    private ProgressBar progressBar;
    private SeekBar seekBar;

    EditText editText1;
    TextView result;
    Button cal;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);


        result = findViewById(R.id.textView4);
        editText1 = findViewById(R.id.NoOfDays);
        cal = findViewById(R.id.button_cal);
        res = findViewById(R.id.result1);

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editText1.getText().toString().length() == 0){
                    editText1.setText("0");
                }if(result.getText().toString().length() == 0){
                    result.setText("0");
                }

                int num1 = Integer.parseInt(editText1.getText().toString());
                int num2 = Integer.parseInt(result.getText().toString());

                int calculate = num1 * num2 / 100;
                res.setText(String.valueOf(calculate));

            }
        });

        textView = (TextView) findViewById(R.id.textView4);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progressBar.setProgress(i);
                textView.setText("" + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}