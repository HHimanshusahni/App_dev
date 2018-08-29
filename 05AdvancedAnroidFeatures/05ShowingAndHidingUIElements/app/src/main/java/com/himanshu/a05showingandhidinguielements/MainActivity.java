package com.himanshu.a05showingandhidinguielements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnHide = (Button)findViewById(R.id.btnHide);
        Button btnShow = (Button)findViewById(R.id.btnShow);
        final TextView textView = (TextView)findViewById(R.id.tvHELLO);
        btnHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setAlpha(0.0f);
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
            textView.setAlpha(1.0f);

            }
        });
    }
}
