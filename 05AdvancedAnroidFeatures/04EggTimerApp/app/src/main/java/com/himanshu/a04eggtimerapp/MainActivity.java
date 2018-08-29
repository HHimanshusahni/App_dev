 package com.himanshu.a04eggtimerapp;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity {

     SeekBar timeSeekBar;
     TextView tvTimer;
     Boolean counterIsActive  = false;
     public void updateTimer(int secondsLeft){

         int minutes = (int)secondsLeft /60;
         int seconds = secondsLeft -minutes *60;

         String secondsString = Integer.toString(seconds);

         if(seconds<=9){
             secondsString = "0"+secondsString;
         }

         tvTimer.setText(Integer.toString(minutes)+":"+secondsString);

     }
     public void controlTimer(View view){
         Log.d("Button presssed","Pressed");

         new CountDownTimer(timeSeekBar.getProgress()*1000+100,1000) {


             @Override
             public void onTick(long millisUntilFinished) {

                 updateTimer((int)millisUntilFinished/1000);
             }

             @Override
             public void onFinish() {

                 tvTimer.setText("0:00"); // otherwise it will remain at the 0:1
                 MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.horn); // not this as it refers to countdowntimer
                 mediaPlayer.start();

                 Log.d("finished","timerdone");
             }
         }.start();
     }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         timeSeekBar = (SeekBar)findViewById(R.id.timerSeekBar);

        tvTimer = (TextView)findViewById(R.id.tvTimer);

        timeSeekBar.setMax(600);// 600 sec = 10 min
        timeSeekBar.setProgress(30);



        timeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                updateTimer(i);

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
