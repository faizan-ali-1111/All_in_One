package com.example.faizanali.allinone;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2,e3,e4,e5;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        b1=(Button)findViewById(R.id.button3);
        b2=(Button)findViewById(R.id.button4);
        e1=(EditText)findViewById(R.id.editText3);
        e2=(EditText)findViewById(R.id.editText4);
        e3=(EditText)findViewById(R.id.editText5);
        e4=(EditText)findViewById(R.id.editText6);
        e5=(EditText)findViewById(R.id.editText7);
        firebaseAuth=FirebaseAuth.getInstance();
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Registration.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString().trim();
                String s2=e2.getText().toString().trim();
                String s3=e3.getText().toString().trim();
                String s4=e4.getText().toString().trim();
                String s5=e5.getText().toString().trim();
                if(TextUtils.isEmpty(s1))
                {
                    e1.setError("fill the username");
                    return;
                }
                else if(TextUtils.isEmpty(s2))
                {
                    e2.setError("fill the password");
                    return;
                }
                else if(TextUtils.isEmpty(s3))
                {
                    e3.setError("fill the profession");
                    return;
                }
                else if(TextUtils.isEmpty(s4))
                {
                    e4.setError("fill the phone number");
                    return;
                }
                else if(TextUtils.isEmpty(s5))
                {
                    e5.setError("fill the city");
                    return;
                }
                final ProgressDialog dialog=ProgressDialog.show(Registration.this,"please wait while connecting","connecting",true);
                firebaseAuth.createUserWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Registration.this, "Registration Done", Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(Registration.this,MainActivity.class);
                            startActivity(i);
                            finish();
                            dialog.dismiss();
                        }
                        else
                        {
                            Toast.makeText(Registration.this, "something went wrong", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }
                });
            }
        });
    }
}
