package com.example.spusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    private int waktu_loading=2500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //setelah loading maka akan langsung berpindah ke home activity
                Intent home = new Intent(SplashScreenActivity.this, Login.class);
                startActivity(home);
                finish();

            }
        },waktu_loading);
    }
}