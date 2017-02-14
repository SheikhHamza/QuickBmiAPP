package com.example.sheikh_hamza.quickbmi;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ResultPage extends AppCompatActivity {

        private TextView BmiText = null;
        private TextView IdealWwightText = null;
        private TextView response = null;
        private TextView OriginalWeighText = null;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_result_page);

            BmiText = (TextView) findViewById(R.id.BmiView);
            IdealWwightText = (TextView) findViewById(R.id.idealWeight);
            response = (TextView) findViewById(R.id.status);
            OriginalWeighText = (TextView) findViewById(R.id.originalweight);

            String bmi = getIntent().getStringExtra("BMIResult");
            String ideal = getIntent().getStringExtra("IdealWeight");
            String Original = getIntent().getStringExtra("OriginalWeight");

            ColorChange(bmi,BmiText);
            SetResponse(bmi,response);
            BmiText.setText(bmi);
            IdealWwightText.setText(ideal);
            OriginalWeighText.setText(Original);



        }

        @Override
        public void onBackPressed() {
            super.onBackPressed();
            overridePendingTransition(R.anim.slide_up,0);
        }

        protected void SetResponse(String value,TextView v) {
            if(Double.parseDouble(value) < 18.5 ) {
                v.setText("You need to put some weight!");
            }
            else if (Double.parseDouble(value) > 18.5 && Double.parseDouble(value) < 24.9 )
            {
                v.setText("You are in great shape!");
            }
            else if (Double.parseDouble(value) > 25.0 && Double.parseDouble(value) < 29.9 )
            {
                v.setText("You need some exercise!");
            }
            else if(Double.parseDouble(value) > 30.0)
            {
                v.setText("Re-plan your diet and do some exercise");
            }
        }


        protected void ColorChange(String value, TextView v)
        {
            if(Double.parseDouble(value) < 18.5 )
            {
                v.setTextColor(Color.YELLOW);
            }
            else if (Double.parseDouble(value) > 18.5 && Double.parseDouble(value) < 24.9 )
            {
                v.setTextColor(Color.GREEN);
            }
            else if (Double.parseDouble(value) > 25.0 && Double.parseDouble(value) < 29.9 )
            {
                v.setTextColor(Color.rgb(255,165,0));
            }
            else if(Double.parseDouble(value) > 30.0)
            {
                v.setTextColor(Color.RED);
            }

        }


}
