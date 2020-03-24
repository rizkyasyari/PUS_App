package com.example.spusapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class NotificationActivity extends AppCompatActivity {

    private ArrayList<String> listNotif = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        ListView lvItem = findViewById(R.id.lv_notif);

        listNotif.add("Segera melakakukan pembayaran sebelum tanggal 10 Januari");
        listNotif.add("Segera melakakukan pembayaran sebelum tanggal 10 Februari");
        listNotif.add("Segera melakakukan pembayaran sebelum tanggal 10 Maret");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, listNotif);

        lvItem.setAdapter(adapter);
    }
    }
