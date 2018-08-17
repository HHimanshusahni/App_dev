package com.himanshu.a03fadinganimations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public  void fade(View view){

        ImageView cartoon1 = findViewById(R.id.cartoon1);


        cartoon1.animate().rotation(1800f).setDuration(2000 );


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
}
