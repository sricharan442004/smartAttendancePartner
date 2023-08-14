package com.example.smartattendancepartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {

    private EditText reg_no,password;
    private Button signin;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        sharedPreferences=getSharedPreferences("MyPrefs",MODE_PRIVATE);

        if(sharedPreferences.getBoolean("logged_in",false)){
            startMainActivity();
        }
        else {
            reg_no=findViewById(R.id.signup_registrationnumber);
            password=findViewById(R.id.signup_password);
            signin=findViewById(R.id.signin_btn);
            signin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
    private void verification(String id,String password){
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putBoolean("logged_in",true);
        editor.apply();
        startMainActivity();

    }
    private void startMainActivity(){
        Intent intent=new Intent(SignupActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}