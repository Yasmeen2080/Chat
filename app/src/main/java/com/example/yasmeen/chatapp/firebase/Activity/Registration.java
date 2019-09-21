package com.example.yasmeen.chatapp.firebase.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yasmeen.chatapp.firebase.DataHolder;
import com.example.yasmeen.chatapp.firebase.Models.Model_user;
import com.example.yasmeen.chatapp.R;
import com.example.yasmeen.chatapp.firebase.Daos.UsersDao;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class Registration extends AppCompatActivity {
EditText username,password,email;
Button btn_register;
    Model_user user;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        email=findViewById(R.id.email);
        btn_register=findViewById(R.id.btn_register);
btn_register.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
String name=username.getText().toString();
String passwordd=password.getText().toString();
        String emailString=email.getText().toString();
       user =new Model_user();
        user.setEmail(emailString);
        user.setPassword(passwordd);
        user.setUsername(name);
        UsersDao.insertUsers(user, new OnSuccessListener() {
            @Override
            public void onSuccess(Object o) {
                DataHolder.currentuser=user;
Intent in=new Intent(Registration.this,HomeActivity.class);
startActivity(in);
            }
        }, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Registration.this,"Errorrrrrrr",Toast.LENGTH_LONG).show();
            }
        });
    }
});

    }




}
