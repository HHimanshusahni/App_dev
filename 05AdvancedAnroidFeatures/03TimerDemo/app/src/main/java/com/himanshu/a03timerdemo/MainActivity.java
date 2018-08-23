package com.himanshu.a03timerdemo;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new CountDownTimer(10000,1000){
            @Override
            public void onTick(long millisecondUntilDone) {

                //CountDown is counting  Down(every second)
                Log.i("Seconds left",String.valueOf(millisecondUntilDone/1000));
            }

            @Override
            public void onFinish() {

                //Counter is finished!!
                Log.i("Done!","Countdown Timer finished");
            }

        }.start();

       /* final Handler handler = new Handler();// It allows chunks of code to run in  delayed time like 5sec itc


        Runnable run = new Runnable() {
            @Override
            public void run() {
                // Insert code to be run every seconds
                Log.i("Runable har run!","a second must have passed!...");
                handler.postDelayed(this,1000);
            }
        };
        handler.post(run);
*/


    }
}
