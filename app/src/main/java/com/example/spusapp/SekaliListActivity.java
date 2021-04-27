package com.example.spusapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.spusapp.Adapter.AnakRutinAdapter;
import com.example.spusapp.Adapter.AnakSekaliAdapter;
import com.example.spusapp.Model.ResponseAnak;
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

public class SekaliListActivity extends AppCompatActivity {
    SessionManager sessionManager;
    ApiService apiService;
    HashMap<String,String> map;

    @BindView(R.id.rv_anak_sekali)
    RecyclerView rvAnakSekali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sekali_list);

        sessionManager = new SessionManager(this);
        apiService = CombineApi.getApiService();
        ButterKnife.bind(this);

        map = sessionManager.getDetailsLogin();

        getAnak(map.get(sessionManager.KEY_PENGGUNA_ID));
    }

    private void getAnak(String idOrtu) {
        apiService.getAnak(idOrtu).enqueue(new Callback<List<ResponseAnak>>() {
            @Override
            public void onResponse(Call<List<ResponseAnak>> call, Response<List<ResponseAnak>> response) {
                Log.d("responseanak",response.body().toString());
                if (response.isSuccessful()){
                    List<ResponseAnak> responseAnakList = response.body();
                    rvAnakSekali.setLayoutManager(new GridLayoutManager(SekaliListActivity.this,1));
                    rvAnakSekali.setHasFixedSize(true);

                    AnakSekaliAdapter anakSekaliAdapter = new AnakSekaliAdapter(responseAnakList);
                    rvAnakSekali.setAdapter(anakSekaliAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<ResponseAnak>> call, Throwable t) {
                Log.d("Error", "onFailure: "+t.toString());
            }
        });
    }
}