package com.example.spusapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.spusapp.Transaction.ProductListActivity;

public class PaymentFragment extends Fragment {

    Button rutin;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment, container, false);
//        return view;
        final Button rutin = (Button) view.findViewById(R.id.btn_rutin);
        rutin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rutin = new Intent(getActivity(),ProductListActivity.class);
                startActivity(rutin);
            }
        });
        return view;
        }
    }


