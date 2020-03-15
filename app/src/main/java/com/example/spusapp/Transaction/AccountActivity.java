package com.example.spusapp.Transaction;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.spusapp.R;


public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        ((TextView) findViewById(R.id.tv_name)).setText(DataCostumer.NAME);
        ((TextView) findViewById(R.id.tv_email)).setText(DataCostumer.EMAIL);
        ((TextView)findViewById(R.id.tv_phone)).setText(DataCostumer.PHONE);
        ((TextView)findViewById(R.id.tv_address)).setText(DataCostumer.ADDRESS);

//        TextView textView = (TextView) findViewById(R.id.tv_name);
//        textView.setText(DataCostumer.NAME);
//
//        TextView textView2 = (TextView) findViewById(R.id.tv_email);
//        textView2.setText(DataCostumer.EMAIL);
//
//        TextView textView3 = (TextView)findViewById(R.id.tv_phone);
//        textView3.setText(DataCostumer.PHONE);
//
//        TextView textView4 = (TextView)findViewById(R.id.tv_address);
//        textView4.setText(DataCostumer.ADDRESS);

    }
}
