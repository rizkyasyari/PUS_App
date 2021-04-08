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

import com.example.spusapp.Model.ResponseUser;
import com.example.spusapp.Network.ApiService;
import com.example.spusapp.Network.CombineApi;
import com.example.spusapp.Utils.SessionManager;
import com.example.spusapp.Utils.SweetAllert;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    private Button lanjutkan, daftar;
    private String verificationId;
    private EditText etNoHp, etPassword;
    ApiService apiService;
    SessionManager sessionManager;
    SweetAllert alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etNoHp = findViewById(R.id.et_nohp);
        etPassword = findViewById(R.id.et_password);
        lanjutkan = findViewById(R.id.tv_lanjutkan);
        alert = new SweetAllert(Login.this);
        apiService = CombineApi.getApiService();
        sessionManager = new SessionManager(Login.this);
        if(sessionManager.isLogin()){
            startActivity(new Intent(Login.this, MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }
//        final ProgressBar progressBar = findViewById(R.id.progressbar);



        lanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                new SweetAlertDialog(Login.this,SweetAlertDialog.SUCCESS_TYPE)
//                        .setTitleText("Sukses")
//                        .show();
//                Intent login = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(login);
                authLogin();
            }
        });

    }

    private void authLogin() {
        String noHp = etNoHp.getText().toString();
        String password = etPassword.getText().toString();
        apiService.login(noHp,password).enqueue(new Callback<ResponseUser>() {
            @Override
            public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
                String code = response.body().getCode();
                Toast.makeText(Login.this, code, Toast.LENGTH_SHORT).show();
                if (code.equals("200")){
                    String id = response.body().getId_orangtua();
                    String noHp = response.body().getNo_hp();
                    String nama = response.body().getOrang_tua();
                    String email = response.body().getEmail();
                    String alamat = response.body().getAlamat();
                    sessionManager.saveLogin(id,noHp,nama,email,alamat);
                    Intent intent = new Intent(Login.this,MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Login.this, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseUser> call, Throwable t) {
                Toast.makeText(Login.this, "Harap Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

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
