 package com.himanshu.a04eggtimerapp;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity {

     SeekBar timeSeekBar;
     TextView tvTimer;
     Boolean counterIsActive  = false;
     Button  btnController ;
     CountDownTimer countDownTimer ;
     public void resetTimer(){
         tvTimer.setText("0:30");
         timeSeekBar.setProgress(30);
         countDownTimer.cancel();
         btnController.setText("Go!");
         timeSeekBar.setEnabled(true);
         counterIsActive = false;
     }
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
         if(counterIsActive == false) {
             counterIsActive = true;
             timeSeekBar.setEnabled(false);
             btnController.setText("STOP");

            countDownTimer =  new CountDownTimer(timeSeekBar.getProgress() * 1000 + 100, 1000) {


                 @Override
                 public void onTick(long millisUntilFinished) {

                     updateTimer((int) millisUntilFinished / 1000);
                 }

                 @Override
                 public void onFinish() {

                     resetTimer();
                     MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.horn); // not this as it refers to countdowntimer
                     mediaPlayer.start();

                     Log.d("finished", "timerdone");
                 }
             }.start();

         }else{
                resetTimer();
         }
     }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         timeSeekBar = (SeekBar)findViewById(R.id.timerSeekBar);

        tvTimer = (TextView)findViewById(R.id.tvTimer);

        timeSeekBar.setMax(600);// 600 sec = 10 min
        timeSeekBar.setProgress(30);
        btnController = (Button)findViewById(R.id.btnController);




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
