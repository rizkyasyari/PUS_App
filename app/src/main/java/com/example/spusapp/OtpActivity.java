

package com.example.spusapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.spusapp.Utils.SessionManager;
import com.example.spusapp.Utils.SweetAllert;

import butterknife.BindView;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class OtpActivity extends AppCompatActivity {

//    SessionManager sessionManager;
//    @BindView(R.id.etPassword)
//    EditText etPassword;
//    @BindView(R.id.etUsername)
//    EditText etUsername;
//    SweetAllert alert;

    private Button lanjutkan;
    EditText edit_text_1,edit_text_2,edit_text_3,edit_text_4,edit_text_5,edit_text_6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        TextView textView = findViewById(R.id.textView);
        textView.setText(String.format(
                "+62-%s", getIntent().getStringExtra("mobile")
        ));

    lanjutkan = (Button)findViewById(R.id.btn_lanjutkan);
    edit_text_1 = (EditText)findViewById(R.id.edit_text_1);
    edit_text_2 = (EditText)findViewById(R.id.edit_text_2);
    edit_text_3 = (EditText)findViewById(R.id.edit_text_3);
    edit_text_4 = (EditText)findViewById(R.id.edit_text_4);
    edit_text_5 = (EditText)findViewById(R.id.edit_text_5);
    edit_text_6 = (EditText)findViewById(R.id.edit_text_6);

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


//    lanjutkan.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            String et_1 = edit_text_1.getText().toString().trim();
//            String et_2 = edit_text_2.getText().toString().trim();
//            String et_3 = edit_text_3.getText().toString().trim();
//            String et_4 = edit_text_4.getText().toString().trim();
//
//
//            if(et_1.equals("1") && et_2.equals("1") && et_3.equals("1") && et_4.equals("1"))
//            {
//
//                new SweetAlertDialog(OtpActivity.this,SweetAlertDialog.SUCCESS_TYPE)
//                        .setTitleText("Sukses")
//                        .show();
//                Intent login = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(login);
//            }
//            else
//            {
//
//                new SweetAlertDialog(OtpActivity.this,SweetAlertDialog.ERROR_TYPE)
//                        .setTitleText("Nomor Inputan Salah")
//                        .show();
//
//            }
//
//
//        }
//    });
        setupOTPInputs();

    }
    private void setupOTPInputs(){
        edit_text_1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    edit_text_2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edit_text_2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    edit_text_3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edit_text_3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    edit_text_4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edit_text_4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    edit_text_5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edit_text_5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    edit_text_6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

}
