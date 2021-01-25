package com.example.spusapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Login extends AppCompatActivity {
    private Button lanjutkan, daftar;
    private String verificationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText inputMobile = findViewById(R.id.et_nohp);
        final Button lanjutkan = findViewById(R.id.tv_lanjutkan);
        final Button daftar = findViewById(R.id.bt_daftar);

        final ProgressBar progressBar = findViewById(R.id.progressbar);



        lanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(OtpActivity.this,SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Sukses")
                        .show();
                Intent login = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(login);
            }
        });

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent daftar = new Intent(getApplicationContext(),DaftarActivity.class);
                startActivity(daftar);
            }
        });
    }}

//                if (inputMobile.getText().toString().trim().isEmpty()) {
//                    Toast.makeText(Login.this, "Enter Mobile", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                progressBar.setVisibility(View.VISIBLE);
//                lanjutkan.setVisibility(View.INVISIBLE);
//
////
//                PhoneAuthProvider.getInstance().verifyPhoneNumber(
//                        "+62" + inputMobile.getText().toString(),        // Phone number to verify
//                        20,                 // Timeout duration
//                        TimeUnit.SECONDS,   // Unit of timeout
//                        Login.this,               // Activity (for callback binding)
//
//                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//                            @Override
//                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
//                                progressBar.setVisibility(View.GONE);
//                                lanjutkan.setVisibility(View.VISIBLE);
//
//                            }
//
//                            @Override
//                            public void onVerificationFailed(@NonNull FirebaseException e) {
//                                progressBar.setVisibility(View.GONE);
//                                lanjutkan.setVisibility(View.VISIBLE);
//                                Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                                Log.w(TAG, "onVerificationFailed: "+e.toString());
//
//
//                            }
//
//                            @Override
//                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
//                                progressBar.setVisibility(View.GONE);
//                                lanjutkan.setVisibility(View.VISIBLE);
//                                Intent intent = new Intent(getApplicationContext(), OtpActivity.class);
//                                intent.putExtra("mobile", inputMobile.getText().toString());
//                                intent.putExtra("verificationId", verificationId);
//                                startActivity(intent);
//                                Log.d(TAG, "onCodeSent: "+verificationId);
//
//                            }
//                        }
//
//
//                );
//
//            }
//
//        });

//
