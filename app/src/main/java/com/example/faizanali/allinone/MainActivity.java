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

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        firebaseAuth=FirebaseAuth.getInstance();
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Registration.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString().trim();
                String s2=e2.getText().toString().trim();
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
                final ProgressDialog dialog=ProgressDialog.show(MainActivity.this,"please wait while connecting","connecting",true);
                firebaseAuth.signInWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(MainActivity.this, "Login Done", Toast.LENGTH_SHORT).show();
                            Intent j=new Intent(MainActivity.this,Welcome.class);
                            startActivity(j);
                            finish();
                            dialog.dismiss();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "User does not exist you can register here", Toast.LENGTH_SHORT).show();
                            Intent k=new Intent(MainActivity.this,Registration.class);
                            startActivity(k);
                            finish();
                            dialog.dismiss();
                        }
                    }
                });
            }
        });
    }
}
