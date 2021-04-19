package com.example.spusapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.spusapp.Transaction.ProductListActivity;

public class PaymentFragment extends Fragment {

    CardView btn_rutin, btn_sekali;
    ImageView image_rutin, image_sekali;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment, container, false);
//        return view;
//        final Button rutin = (Button) view.findViewById(R.id.btn_rutin);
//        rutin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent rutin = new Intent(getActivity(),ProductListActivity.class);
//                startActivity(rutin);
//            }
//        });

        btn_rutin = (CardView) view.findViewById(R.id.btn_rutin);
        btn_sekali = (CardView)view.findViewById(R.id.btn_sekali);

        image_rutin = (ImageView) view.findViewById(R.id.bg_rutin);
        image_rutin.setAlpha(135); //value: [0-255]. Where 0 is fully transparent and 255 is fully opaque.

        image_sekali = (ImageView) view.findViewById(R.id.bg_sekali);
        image_sekali.setAlpha(135); //value: [0-255]. Where 0 is fully transparent and 255 is fully opaque.

        btn_rutin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn_rutin = new Intent(getActivity(),RutinListActivity.class);
                startActivity(btn_rutin);
            }
        });

        return view;
        }
    }


