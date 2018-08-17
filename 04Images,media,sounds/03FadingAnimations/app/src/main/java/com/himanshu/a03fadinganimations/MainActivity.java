package com.himanshu.a03fadinganimations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public  void fade(View view){

        ImageView cartoon1 = findViewById(R.id.cartoon1);

        ImageView cartoon2 = findViewById(R.id.cartoon2);

        cartoon1.animate().translationXBy(-1000f).setDuration(2000 ); //y is the vertical axis


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
