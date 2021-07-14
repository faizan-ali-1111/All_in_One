package com.example.faizanali.allinone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Calcoption extends AppCompatActivity {
    Button b1,b2,b3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcoption);
        b1=(Button)findViewById(R.id.button22);
        b2=(Button)findViewById(R.id.button21);
        b3=(Button)findViewById(R.id.button30);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Calcoption.this,Calculator.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Calcoption.this,Scical.class);
                startActivity(j);
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k=new Intent(Calcoption.this,Welcome.class);
                startActivity(k);
                finish();
            }
        });
    }
}
