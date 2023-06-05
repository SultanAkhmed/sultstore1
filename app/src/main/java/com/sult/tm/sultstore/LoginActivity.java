package com.sult.tm.sultstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    FirebaseAuth sAuth;
    EditText edEmail, edPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    public void init(){
        edEmail = findViewById(R.id.email);
        edPassword = findViewById(R.id.password);
        sAuth = FirebaseAuth.getInstance();
    }

    public void onReg(View view){
        startActivity(new Intent(LoginActivity.this, RegActivity.class));
    }

    public void LogIn(View view){
        String email = edEmail.getText().toString();
        String password = edPassword.getText().toString();
        sAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
    }

}