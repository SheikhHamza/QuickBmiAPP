package com.example.sheikh_hamza.quickbmi;

import android.content.Intent;
import android.opengl.EGLDisplay;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    boolean gender = true;
    SeekBar Height = null;
    SeekBar Weight = null;
    SeekBar Age = null;

    EditText height = null;
    EditText weight = null;
    EditText age = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Height = (SeekBar) findViewById(R.id.height);
        Weight = (SeekBar) findViewById(R.id.weight);
        Age    = (SeekBar) findViewById(R.id.Age);

        height = (EditText) findViewById(R.id.h);
        weight = (EditText) findViewById(R.id.w);
        age    = (EditText) findViewById(R.id.a);


        Height.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                height.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        Weight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                weight.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Age.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                age.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        height.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                {
                    if(!(height.getText().toString().trim().length() == 0))
                    Height.setProgress(Integer.parseInt(height.getText().toString()));
                }

            }
        });

        weight.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                {
                    if(!(weight.getText().toString().trim().length() == 0))
                    Weight.setProgress(Integer.parseInt(weight.getText().toString()));
                }
            }
        });

        age.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                {
                    if(!(age.getText().toString().trim().length() == 0))
                    Age.setProgress(Integer.parseInt(age.getText().toString()));
                }
            }
        });

    }



    public  void onRadioButtonClick(View v)
    {
        switch(v.getId())
        {
            case R.id.male:
                gender = true;
                break;
            case R.id.female:
                gender = false;
                break;
        }
    }

    public void Calculate(View v){

        if( height.getText().toString().trim().length() == 0 || (Double.parseDouble(height.getText().toString())) == 0 )
        {
            Toast toast = Toast.makeText(getApplicationContext(),"Height Can't be Empty!", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        else if(weight.getText().toString().trim().length() == 0 || (Double.parseDouble(weight.getText().toString())) == 0 )
        {
            Toast toast = Toast.makeText(getApplicationContext(),"Weight Can't be Empty!", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        double kg = (Double.parseDouble(weight.getText().toString()));
        double height_in_meter =  (Double.parseDouble(height.getText().toString()) * 0.025);
        double  height_sq = height_in_meter * height_in_meter;

        double result ;

        result = kg/height_sq ;

        //Result.setText(String.valueOf(result));

        double  IdealWeight = (22 * height_sq);


        Intent myintent = new Intent(this, ResultPage.class).putExtra("BMIResult", String.format("%.2f",result));
        myintent.putExtra("IdealWeight",String.format("%.2f",IdealWeight) + " kg");
        myintent.putExtra("OriginalWeight",String.format("%.2f",kg) + " kg");

        startActivity(myintent);
        overridePendingTransition(R.anim.slide_up,R.anim.slide_down);

    }


}


