package com.himanshu.a03fadinganimations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public  void fade(View view){
        // to fade the image when we tap on it
        ImageView cartoon1 = findViewById(R.id.cartoon1);

        // what to change and for how long for the change to happen
        // alpha is no from 0 to 1 how transparent the image is , 0 is invisible ,1 is completeley visible

        ImageView cartoon2 = findViewById(R.id.cartoon2);

        cartoon1.animate().alpha(0f).setDuration(2000 ); // f is there to make it float
        cartoon2.animate().alpha(1f).setDuration(2000);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
