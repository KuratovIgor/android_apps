package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView MyVideoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyVideoPlayer =  (VideoView)findViewById(R.id.videoView);
        Uri myVideoUri= Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.video);
        MyVideoPlayer.setVideoURI(myVideoUri);
        MediaController mediaController = new MediaController(this);
        MyVideoPlayer.setMediaController(mediaController);
        mediaController.setMediaPlayer(MyVideoPlayer);

    }

    public void onStartClick(View view) {
        MyVideoPlayer.start();
    }

    public void onPauseClick(View view) {
        MyVideoPlayer.pause();
    }

    public void onStopClick(View view) {
        MyVideoPlayer.stopPlayback();
        MyVideoPlayer.resume();
    }

    public void onAudioClick(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}