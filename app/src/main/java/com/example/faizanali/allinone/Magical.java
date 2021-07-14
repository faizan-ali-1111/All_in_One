package com.example.faizanali.allinone;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.TriggerEventListener;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Magical extends AppCompatActivity implements SensorEventListener{
    MediaPlayer mp;
    SensorManager sm;
    Sensor s;
    private boolean flashlight=false;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magical);
        mp=MediaPlayer.create(this,R.raw.pht);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);

        b1=(Button)findViewById(R.id.button42);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //onPause();
                onStop();
                flashoff();
                mp.stop();
                Toast.makeText(Magical.this, "Magical Music Off", Toast.LENGTH_SHORT).show();

                Intent i=new Intent(Magical.this,Special.class);
                startActivity(i);
                finish();
            }
        });

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x=sensorEvent.values[0];
        float y=sensorEvent.values[1];
        float z=sensorEvent.values[2];

        int x1=(int)x;
        int y1=(int)y;
        int z1=(int)z;


                if (x1 != 0) {
                    vib();
                    mp.start();
                    flashon();
                    //Toast.makeText(Magical.this, "Magical Music On", Toast.LENGTH_SHORT).show();
                } else {
                    mp.pause();
                    flashoff();
                    //Toast.makeText(Magical.this, "Magical Music Off", Toast.LENGTH_SHORT).show();
                }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    /**
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are <em>not</em> resumed.  This means
     * that in some cases the previous state may still be saved, not allowing
     * fragment transactions that modify the state.  To correctly interact
     * with fragments in their proper state, you should instead override
     * {@link #onResumeFragments()}.
     */
    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
    }

    /**
     * Dispatch onPause() to fragments.
     */
   /* @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }*/

    @Override
    protected void onStop() {
        super.onStop();
        sm.unregisterListener(this);

    }

    public void vib()
    {

        Vibrator  vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        if(Build.VERSION.SDK_INT>=26)
        {
            vibrator.vibrate(300);
        }
        else
        {
        vibrator.vibrate(300);
        }
    }
    public void flashon()
    {
        CameraManager cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        try
        {
            String cameraid=cm.getCameraIdList()[0];
            cm.setTorchMode(cameraid,true);
            flashlight=true;
        }
        catch (CameraAccessException e)
        {

        }
    }
    public void flashoff()
    {
        CameraManager cm1=(CameraManager)getSystemService(CAMERA_SERVICE);
        try
        {
            String cameraid1=cm1.getCameraIdList()[0];
            cm1.setTorchMode(cameraid1,false);
            flashlight=false;
        }
        catch (CameraAccessException e)
        {

        }
    }




}
