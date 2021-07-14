package com.example.faizanali.allinone;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    Button b1,b2,b3,b4;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        t1=(TextView)findViewById(R.id.textView21);
        b1=(Button)findViewById(R.id.button49);
        b2=(Button)findViewById(R.id.button50);
        b3=(Button)findViewById(R.id.button51);
        b4=(Button)findViewById(R.id.button52);
        t1.setText("Your result is "+Quiz1.score);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.facebook.com"));
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com"));
                startActivity(j);

            }

        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.netcamp.in"));
                startActivity(k);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l=new Intent(Result.this,Welcome.class);
                startActivity(l);
                finish();
            }
        });
    }
}
