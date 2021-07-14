package com.example.faizanali.allinone;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class Mediaplayer extends AppCompatActivity {
    Button b1,b2,b3;
    MediaPlayer mp;
    SeekBar s1;
    Runnable r1;
    Handler h1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediaplayer);
        b1=(Button)findViewById(R.id.button11);
        b2=(Button)findViewById(R.id.button12);
        b3=(Button)findViewById(R.id.button13);
        mp=MediaPlayer.create(this,R.raw.pht);
        s1=(SeekBar)findViewById(R.id.seekBar);
        h1=new Handler();
        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                s1.setMax(mp.getDuration());
                mp.start();
                changeseekbar();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });
        s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(mp!=null&&b)
                {
                    mp.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.stop();
                Intent i=new Intent(Mediaplayer.this,Welcome.class);
                startActivity(i);
                finish();
            }
        });

    }
    private void changeseekbar()
    {
        s1.setProgress(mp.getCurrentPosition());
        if(mp.isPlaying())
        {
            r1=new Runnable() {
                @Override
                public void run() {
                    changeseekbar();
                }
            };
            h1.postDelayed(r1,1000);
        }
    }
}
