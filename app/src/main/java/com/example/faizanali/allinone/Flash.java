package com.example.faizanali.allinone;

import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Flash extends AppCompatActivity {
    ImageButton b1,b2;
    Button back;
    private boolean flashlight=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        back=(Button)findViewById(R.id.button14);
        b1=(ImageButton)findViewById(R.id.imageButton);
        b2=(ImageButton)findViewById(R.id.imageButton2);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Flash.this,Welcome.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flashon();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flashoff();
            }
        });

    }
    public void flashon()
    {
        CameraManager c1=(CameraManager)getSystemService(CAMERA_SERVICE);
        try
        {
            String cameraid=c1.getCameraIdList()[0];
            c1.setTorchMode(cameraid,true);
            flashlight=true;
        }
        catch (CameraAccessException e)
        {

        }
    }

    public void flashoff()
    {
        CameraManager c2=(CameraManager)getSystemService(CAMERA_SERVICE);
        try
        {
            String cameraid1=c2.getCameraIdList()[0];
            c2.setTorchMode(cameraid1,false);
            flashlight=false;
        }
        catch (CameraAccessException e)
        {

        }
    }
}
