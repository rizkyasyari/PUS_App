package com.example.spusapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spusapp.Adapter.CustomAdapter;
import com.example.spusapp.Adapter.RiwayatAdapter;
import com.example.spusapp.Model.ResponseRiwayat;
import com.example.spusapp.Network.ApiService;
import com.example.spusapp.Network.CombineApi;
import com.example.spusapp.Utils.SessionManager;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HistoryFragment extends Fragment {
    SessionManager sessionManager;
    ApiService apiService;
    HashMap<String,String> map;

    @BindView(R.id.rv_history)
    RecyclerView rvHistory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_history, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sessionManager = new SessionManager(getContext());
        apiService = CombineApi.getApiService();

        map = sessionManager.getDetailsLogin();

        getRiwayat(map.get(sessionManager.KEY_PENGGUNA_ID));
    }

    private void getRiwayat(String idOrangtua) {
        apiService.riwayatTagihan(idOrangtua).enqueue(new Callback<List<ResponseRiwayat>>() {
            @Override
            public void onResponse(Call<List<ResponseRiwayat>> call, Response<List<ResponseRiwayat>> response) {
                if (response.isSuccessful()){
                    List<ResponseRiwayat> responseRiwayatList = response.body();
                    if (rvHistory != null){
                        rvHistory.setLayoutManager(new GridLayoutManager(getContext(),1));
                        rvHistory.setHasFixedSize(true);

                        RiwayatAdapter riwayatAdapter = new RiwayatAdapter(responseRiwayatList);
                        rvHistory.setAdapter(riwayatAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ResponseRiwayat>> call, Throwable t) {
                Log.d("Error",t.toString());
            }
        });
    }
}