package com.example.faizanali.allinone;

import android.content.Intent;
import android.renderscript.Double2;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class Scical extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7;
    EditText e1;
    TextView t1;
    TextToSpeech ts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scical);
        b1=(Button)findViewById(R.id.button23);
        b2=(Button)findViewById(R.id.button24);
        b3=(Button)findViewById(R.id.button25);
        b4=(Button)findViewById(R.id.button26);
        b5=(Button)findViewById(R.id.button27);
        b6=(Button)findViewById(R.id.button28);
        b7=(Button)findViewById(R.id.button31);
        e1=(EditText)findViewById(R.id.editText10);
        t1=(TextView)findViewById(R.id.textView11);
        ts=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                ts.setSpeechRate(0.3f);
                ts.setLanguage(Locale.ENGLISH);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                Float x=Float.parseFloat(s1);
                Double y=Math.toRadians(x);

                Double res=Math.sin(y);
                String s2= Double.toString(res);
                t1.setText(s2);
                ts.speak("result is"+s2,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                Float x=Float.parseFloat(s1);
                Double y=Math.toRadians(x);

                Double res=Math.cos(y);
                String s2= Double.toString(res);
                t1.setText(s2);
                ts.speak("result is"+s2,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                Float x=Float.parseFloat(s1);
                Double y=Math.toRadians(x);

                Double res=Math.tan(y);
                String s2= Double.toString(res);
                t1.setText(s2);
                ts.speak("result is"+s2,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                Float x=Float.parseFloat(s1);
                Double y=Math.toRadians(x);

                Double res=Math.tan(y);
                Double res1=(1/res);
                String s2= Double.toString(res1);
                t1.setText(s2);
                ts.speak("result is"+s2,TextToSpeech.QUEUE_FLUSH,null);


            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                Float x=Float.parseFloat(s1);
                Double y=Math.toRadians(x);

                Double res=Math.cos(y);
                Double res1=(1/res);
                String s2= Double.toString(res1);
                t1.setText(s2);
                ts.speak("result is"+s2,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                Float x=Float.parseFloat(s1);
                Double y=Math.toRadians(x);

                Double res=Math.sin(y);
                Double res1=(1/res);
                String s2= Double.toString(res1);
                t1.setText(s2);
                ts.speak("result is"+s2,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k=new Intent(Scical.this,Calcoption.class);
                startActivity(k);
                finish();

            }
        });


     }
}
