package com.example.spusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelesaiTransaksiActivity extends AppCompatActivity {

    @BindView(R.id.btn_selesai_beranda)
    Button btnSelesaiBeranda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selesai_transaksi);
        ButterKnife.bind(this);

        btnSelesaiBeranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelesaiTransaksiActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}