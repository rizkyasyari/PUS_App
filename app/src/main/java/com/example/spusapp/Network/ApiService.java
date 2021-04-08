package com.example.spusapp.Network;

import com.example.spusapp.Model.ResponseAnak;
import com.example.spusapp.Model.ResponseUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("login")
    Call<ResponseUser> login(
            @Field("no_hp") String no_hp,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("get-anak")
    Call<List<ResponseAnak>> getAnak(
            @Field("id_orangtua") String id_orangtua
    );
}
