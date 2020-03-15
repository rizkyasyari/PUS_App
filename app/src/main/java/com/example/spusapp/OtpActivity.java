package com.example.spusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class OtpActivity extends AppCompatActivity {

    private Button lanjutkan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

    lanjutkan = (Button)findViewById(R.id.btn_lanjutkan);

    lanjutkan.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent login = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(login);
        }
    });

    }

}
