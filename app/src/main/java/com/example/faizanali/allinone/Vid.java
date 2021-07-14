package com.example.faizanali.allinone;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Vid extends AppCompatActivity {
    Button b1,b2;
    VideoView v1;
    Uri uri;
    MediaController m1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vid);
        b1=(Button)findViewById(R.id.button37);
        b2=(Button)findViewById(R.id.button38);
        v1=(VideoView)findViewById(R.id.videoView);
        m1=new MediaController(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(i,0);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Vid.this,Welcome.class);
                startActivity(j);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uri=data.getData();
        v1.setVideoURI(uri);
        v1.setMediaController(m1);
        m1.setAnchorView(v1);
        v1.start();
    }
}
