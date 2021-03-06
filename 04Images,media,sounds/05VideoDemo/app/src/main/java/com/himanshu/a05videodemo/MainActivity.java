package com.himanshu.a05videodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoView = (VideoView)findViewById(R.id.idVideoView);

        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.videodemo);

        MediaController mediaController = new MediaController(this);

        mediaController.setAnchorView(videoView);// videoView becomes anchor view for the  mediaController
        videoView.setMediaController(mediaController);


        videoView.start();
    }
}
