package com.example.spusapp.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseUser {
    @SerializedName("orang_tua") String orang_tua;
    @SerializedName("id_orangtua") String id_orangtua;
    @SerializedName("id_sekolah") String id_sekolah;
    @SerializedName("no_hp") String no_hp;
    @SerializedName("email") String email;
    @SerializedName("alamat") String alamat;
    @SerializedName("nik") String nik;
    @SerializedName("id") String id;
    @SerializedName("name") String name;
    @SerializedName("id_akses") String id_akses;
    @SerializedName("status") String status;
    @SerializedName("akun") String akun;

    @SerializedName("code") String code;
    @SerializedName("message") String message;

    public String getOrang_tua() {
        return orang_tua;
    }

    public void setOrang_tua(String orang_tua) {
        this.orang_tua = orang_tua;
    }

    public String getId_orangtua() {
        return id_orangtua;
    }

    public void setId_orangtua(String id_orangtua) {
        this.id_orangtua = id_orangtua;
    }

    public String getId_sekolah() {
        return id_sekolah;
    }

    public void setId_sekolah(String id_sekolah) {
        this.id_sekolah = id_sekolah;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_akses() {
        return id_akses;
    }

    public void setId_akses(String id_akses) {
        this.id_akses = id_akses;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAkun() {
        return akun;
    }

    public void setAkun(String akun) {
        this.akun = akun;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
