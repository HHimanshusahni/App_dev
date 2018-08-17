package com.himanshu.a03fadinganimations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public  void fade(View view){

        ImageView cartoon1 = findViewById(R.id.cartoon1);


        cartoon1.animate()
                .translationXBy(1000f)
                .translationYBy(1000f)
                .rotationBy(3600)
                .setDuration(2000 );


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView cartoon1 = findViewById(R.id.cartoon1);
        cartoon1.setTranslationX(-1000f);
        cartoon1.setTranslationY(-1000f);


    }
}
