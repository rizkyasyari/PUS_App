package com.example.spusapp.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseAnak {
    @SerializedName("id_siswa") String id_siswa;
    @SerializedName("nama_siswa") String nama_siswa;
    @SerializedName("nisn") String nisn;
    @SerializedName("tgl_lahir") String tgl_lahir;
    @SerializedName("tahun_masuk") String tahun_masuk;
    @SerializedName("id_orangtua") String id_orangtua;
    @SerializedName("status") String status;
    @SerializedName("id_sekolah") String id_sekolah;
    @SerializedName("id_kelas") String id_kelas;
    @SerializedName("id_jurusan") String id_jurusan;
    @SerializedName("id_tahun_ajaran") String id_tahun_ajaran;

    public String getId_siswa() {
        return id_siswa;
    }

    public void setId_siswa(String id_siswa) {
        this.id_siswa = id_siswa;
    }

    public String getNama_siswa() {
        return nama_siswa;
    }

    public void setNama_siswa(String nama_siswa) {
        this.nama_siswa = nama_siswa;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public String getTahun_masuk() {
        return tahun_masuk;
    }

    public void setTahun_masuk(String tahun_masuk) {
        this.tahun_masuk = tahun_masuk;
    }

    public String getId_orangtua() {
        return id_orangtua;
    }

    public void setId_orangtua(String id_orangtua) {
        this.id_orangtua = id_orangtua;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId_sekolah() {
        return id_sekolah;
    }

    public void setId_sekolah(String id_sekolah) {
        this.id_sekolah = id_sekolah;
    }

    public String getId_kelas() {
        return id_kelas;
    }

    public void setId_kelas(String id_kelas) {
        this.id_kelas = id_kelas;
    }

    public String getId_jurusan() {
        return id_jurusan;
    }

    public void setId_jurusan(String id_jurusan) {
        this.id_jurusan = id_jurusan;
    }

    public String getId_tahun_ajaran() {
        return id_tahun_ajaran;
    }

    public void setId_tahun_ajaran(String id_tahun_ajaran) {
        this.id_tahun_ajaran = id_tahun_ajaran;
    }
}
