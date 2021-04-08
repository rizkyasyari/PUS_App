package com.example.spusapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.spusapp.Adapter.AnakAdapter;
import com.example.spusapp.Model.ResponseAnak;
import com.example.spusapp.Network.ApiService;
import com.example.spusapp.Network.CombineApi;
import com.example.spusapp.Transaction.DataCustumer;
import com.example.spusapp.Utils.SessionManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountFragment extends Fragment {
    @BindView(R.id.btn_logout)
    Button btnLogout;
    @BindView(R.id.tv_nama_ortu)
    TextView tvNamaOrtu;
    @BindView(R.id.tv_email_ortu)
    TextView tvEmailOrtu;
    @BindView(R.id.tv_no_hp_ortu)
    TextView tvNoHpOrtu;
    @BindView(R.id.tv_alamat_ortu)
    TextView tvAlamatOrtu;

    SessionManager sessionManager;
    ApiService apiService;
    HashMap<String,String> map;

    @BindView(R.id.lv_anak)
    ListView lvAnak;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sessionManager = new SessionManager(getContext());
        apiService = CombineApi.getApiService();

        map = sessionManager.getDetailsLogin();

        tvNamaOrtu.setText(map.get(sessionManager.KEY_PENGGUNA_NAMA));
        tvEmailOrtu.setText(map.get(sessionManager.KEY_PENGGUNA_EMAIL));
        tvNoHpOrtu.setText(map.get(sessionManager.KEY_NOMOR_HP));
        tvAlamatOrtu.setText(map.get(sessionManager.KEY_PENGGUNA_ALAMAT));

        getAnak(map.get(sessionManager.KEY_PENGGUNA_ID));

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.logout();
                Intent i = new Intent(getActivity(),Login.class);
                startActivity(i);
                getActivity().finish();
            }
        });
    }

    private void getAnak(String idOrtu) {
        apiService.getAnak(idOrtu).enqueue(new Callback<List<ResponseAnak>>() {
            @Override
            public void onResponse(Call<List<ResponseAnak>> call, Response<List<ResponseAnak>> response) {
                Log.d("responseanak",response.body().toString());
                if (response.isSuccessful()){
                    List<ResponseAnak> responseAnakList = response.body();
                    lvAnak.setAdapter(new AnakAdapter(getActivity(),R.layout.list_anak,responseAnakList));
                }
            }

            @Override
            public void onFailure(Call<List<ResponseAnak>> call, Throwable t) {
                Log.d("Error", "onFailure: "+t.toString());
            }
        });
    }
}
