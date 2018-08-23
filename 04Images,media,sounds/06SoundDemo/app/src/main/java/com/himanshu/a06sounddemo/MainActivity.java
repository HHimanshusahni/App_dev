package com.himanshu.a06sounddemo;

import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer ;

    AudioManager audioManager;



    public void playAudio(View view){
        mediaPlayer.start();
    }
    public  void pauseAudio(View view){
        mediaPlayer.pause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this,R.raw.kidlaugh);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        int  maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int  curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        SeekBar volumeControl =(SeekBar) findViewById(R.id.seekBar);
        volumeControl.setMax(maxVolume);
        volumeControl.setProgress(curVolume);

        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("SeekBar value", String.valueOf(seekBar.getProgress()));

                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,seekBar.getProgress(),0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final SeekBar scrubber = findViewById(R.id.scrubber);
       scrubber.setMax(mediaPlayer.getDuration());

       new Timer().scheduleAtFixedRate(new TimerTask() {
           @Override
           public void run() {
            scrubber.setProgress(mediaPlayer.getCurrentPosition()   );
           }
       },0,100);// run the code immediately and after every  10th second

        scrubber.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                mediaPlayer.seekTo(seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mediaPlayer.pause();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.start();
            }
        });



    }
}
