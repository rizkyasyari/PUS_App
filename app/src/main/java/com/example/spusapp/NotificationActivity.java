package com.example.spusapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

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
