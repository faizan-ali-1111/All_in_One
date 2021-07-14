package com.example.faizanali.allinone;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Cam extends AppCompatActivity {
    Button b1,b2;
    ImageView i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam);
        b1=(Button)findViewById(R.id.button35);
        b2=(Button)findViewById(R.id.button36);


        i1=(ImageView)findViewById(R.id.imageView8);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i2,0);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Cam.this,Cameraoption.class);
                startActivity(j);
                finish();
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        Bitmap bm=(Bitmap)data.getExtras().get("data");
        i1.setImageBitmap(bm);
    }
}
