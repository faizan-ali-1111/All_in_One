package com.example.faizanali.allinone;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class Calculator extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7;
    EditText e1,e2;
    TextView t1;
    TextToSpeech ts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        b1=(Button)findViewById(R.id.button15);
        b2=(Button)findViewById(R.id.button16);
        b3=(Button)findViewById(R.id.button17);
        b4=(Button)findViewById(R.id.button18);
        b5=(Button)findViewById(R.id.button19);
        b6=(Button)findViewById(R.id.button20);
        b7=(Button)findViewById(R.id.button29);
        e1=(EditText)findViewById(R.id.editText8);
        e2=(EditText)findViewById(R.id.editText9);
        t1=(TextView)findViewById(R.id.textView7);
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
                String s2=e2.getText().toString();
                int x=Integer.parseInt(s1);
                int y=Integer.parseInt(s2);
                int sum=x+y;
                String s3=Integer.toString(sum);
                t1.setText(s3);


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                int x=Integer.parseInt(s1);
                int y=Integer.parseInt(s2);
                int sum=x*y;
                String s3=Integer.toString(sum);
                t1.setText(s3);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                int x=Integer.parseInt(s1);
                int y=Integer.parseInt(s2);
                int sum=x-y;
                String s3=Integer.toString(sum);
                t1.setText(s3);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                int x=Integer.parseInt(s1);
                int y=Integer.parseInt(s2);
                int sum=x/y;
                String s3=Integer.toString(sum);
                t1.setText(s3);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=t1.getText().toString();
                ts.speak("result is"+s,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("");
                e2.setText("");
                t1.setText("");

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Calculator.this,Calcoption.class);
                startActivity(j);
                finish();
            }
        });

    }
}
