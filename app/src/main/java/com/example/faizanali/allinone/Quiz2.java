package com.example.faizanali.allinone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Quiz2 extends AppCompatActivity {
    RadioButton r1, r2, r3, r4;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
        b1=(Button)findViewById(R.id.button45);
        b2=(Button)findViewById(R.id.button46);
        r1=(RadioButton)findViewById(R.id.radioButton5);
        r2=(RadioButton)findViewById(R.id.radioButton6);
        r3=(RadioButton)findViewById(R.id.radioButton7);
        r4=(RadioButton)findViewById(R.id.radioButton8);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(r2.isChecked())
                {
                    ++Quiz1.score;
                }
                Intent i=new Intent(Quiz2.this,Quz3.class);
                startActivity(i);
                finish();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Quiz2.this,Special.class);
                startActivity(j);
                finish();
            }
        });
    }
}
