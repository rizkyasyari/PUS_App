package com.example.spusapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.spusapp.Model.ResponseTotalTagihan;
import com.example.spusapp.Network.ApiService;
import com.example.spusapp.Network.CombineApi;
import com.example.spusapp.Utils.SessionManager;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    CardView btn_account,btn_histori,btn_tutorial,btn_chat,btn_pay;
    ImageView image_notif,image_pay;
    TextView tvTotalRutin,tvTotalSekali;

    SessionManager sessionManager;
    ApiService apiService;
    HashMap<String,String> map;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
//        btn_pay = (CardView) view.findViewById(R.id.btn_pay);
        btn_account = (CardView)view.findViewById(R.id.btn_account);
        btn_histori = (CardView)view.findViewById(R.id.btn_histori);
        btn_chat = (CardView)view.findViewById(R.id.btn_chat);
        btn_tutorial = (CardView)view.findViewById(R.id.btn_tutorial);
        image_pay = (ImageView) view.findViewById(R.id.bg_pay);
        tvTotalRutin = (TextView) view.findViewById(R.id.tv_total_bulan);
        tvTotalSekali = (TextView) view.findViewById(R.id.tv_total_semester);
        image_pay.setAlpha(127); //value: [0-255]. Where 0 is fully transparent and 255 is fully opaque.

        sessionManager = new SessionManager(getContext());
        apiService = CombineApi.getApiService();

        map = sessionManager.getDetailsLogin();
        getTotal(map.get(sessionManager.KEY_PENGGUNA_ID));

        btn_tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn_tutorial = new Intent(getActivity(),TutorialActivity.class);
                startActivity(btn_tutorial);
            }
        });

//        btn_chat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent btn_chat = new Intent(getActivity(),ChatActivity.class);
//                startActivity(btn_chat);
//            }
//        });

        btn_histori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HistoryFragment historyFragment = new HistoryFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_container,historyFragment);
                transaction.commit();
            }
        });

        btn_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountFragment accountFragment = new AccountFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_container,accountFragment);
                transaction.commit();
            }
        });

        btn_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PaymentFragment paymentFragment = new PaymentFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_container,paymentFragment);
                transaction.commit();
            }
        });


    ImageView image_notif = (ImageView) view.findViewById(R.id.image_notif);
    image_notif.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent image_notif = new Intent(getActivity(),NotificationActivity.class);
            startActivity(image_notif);
        }
    });

        return view;
    }

    private void getTotal(String idOrangTua) {
        apiService.totalTagihan(idOrangTua,"Rutin").enqueue(new Callback<ResponseTotalTagihan>() {
            @Override
            public void onResponse(Call<ResponseTotalTagihan> call, Response<ResponseTotalTagihan> response) {
                if (response.isSuccessful()){
                    if (response.body() != null) {
                        tvTotalRutin.setText("Rp. "+response.body().getTotal_tagihan());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseTotalTagihan> call, Throwable t) {
                Log.d("totalte",t.toString());
            }
        });
        apiService.totalTagihan(idOrangTua,"Sekali Bayar").enqueue(new Callback<ResponseTotalTagihan>() {
            @Override
            public void onResponse(Call<ResponseTotalTagihan> call, Response<ResponseTotalTagihan> response) {
                if (response.isSuccessful()){
                    if (response.body() != null) {
                        tvTotalSekali.setText("Rp. "+response.body().getTotal_tagihan());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseTotalTagihan> call, Throwable t) {
                Log.d("totalte",t.toString());
            }
        });
    }
}
