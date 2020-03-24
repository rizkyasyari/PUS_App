package com.example.spusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class OtpActivity extends AppCompatActivity {

    private Button lanjutkan;
    EditText edit_text_1,edit_text_2,edit_text_3,edit_text_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

    lanjutkan = (Button)findViewById(R.id.btn_lanjutkan);
    edit_text_1 = (EditText)findViewById(R.id.edit_text_1);
    edit_text_2 = (EditText)findViewById(R.id.edit_text_2);
    edit_text_3 = (EditText)findViewById(R.id.edit_text_3);
    edit_text_4 = (EditText)findViewById(R.id.edit_text_4);

    lanjutkan.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String et_1 = edit_text_1.getText().toString().trim();
            String et_2 = edit_text_2.getText().toString().trim();
            String et_3 = edit_text_3.getText().toString().trim();
            String et_4 = edit_text_4.getText().toString().trim();


            if(et_1.equals("1") && et_2.equals("1") && et_3.equals("1") && et_4.equals("1"))
            {

                new SweetAlertDialog(OtpActivity.this,SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Sukses")
                        .show();
                Intent login = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(login);
            }
            else
            {

                new SweetAlertDialog(OtpActivity.this,SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Nomor Inputan Salah")
                        .show();
//                SweetAlertDialog pDialog = new SweetAlertDialog(OtpActivity.this, SweetAlertDialog.PROGRESS_TYPE);
//                pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
//                pDialog.setTitleText("Loading");
//                pDialog.setCancelable(false);
//                pDialog.show();
            }


        }
    });

    }

}
