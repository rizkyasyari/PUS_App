package com.example.spusapp.Network;

import com.example.spusapp.Model.ResponseAnak;
import com.example.spusapp.Model.ResponseRiwayat;
import com.example.spusapp.Model.ResponseTagihan;
import com.example.spusapp.Model.ResponseUpdate;
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

    @FormUrlEncoded
    @POST("get-tagihan")
    Call<List<ResponseTagihan>> getTagihan(
            @Field("id_siswa") String id_siswa,
            @Field("status_bayar") String status_bayar
    );

    @FormUrlEncoded
    @POST("update-tagihan")
    Call<ResponseUpdate> updateTagihan(
            @Field("id_tagihan") String id_tagihan,
            @Field("status_bayar") String status_bayar,
            @Field("tanggal_bayar") String tanggal_bayar,
            @Field("order_id") String order_id
    );

    @FormUrlEncoded
    @POST("riwayat-tagihan")
    Call<List<ResponseRiwayat>> riwayatTagihan(
            @Field("id_orangtua") String id_orangtua
    );
}
