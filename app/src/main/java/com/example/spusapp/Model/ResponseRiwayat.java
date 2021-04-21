package com.example.spusapp.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseRiwayat {

    @SerializedName("jenis_pembayaran") String jenis_pembayaran;
    @SerializedName("nama_pembayaran") String nama_pembayaran;
    @SerializedName("tanggal_pembayaran") String tanggal_pembayaran;
    @SerializedName("jumlah_bayar") String jumlah_bayar;
    @SerializedName("nama_siswa") String nama_siswa;
    @SerializedName("status_bayar") String status_bayar;

    public String getJenis_pembayaran() {
        return jenis_pembayaran;
    }

    public void setJenis_pembayaran(String jenis_pembayaran) {
        this.jenis_pembayaran = jenis_pembayaran;
    }

    public String getNama_pembayaran() {
        return nama_pembayaran;
    }

    public void setNama_pembayaran(String nama_pembayaran) {
        this.nama_pembayaran = nama_pembayaran;
    }

    public String getTanggal_pembayaran() {
        return tanggal_pembayaran;
    }

    public void setTanggal_pembayaran(String tanggal_pembayaran) {
        this.tanggal_pembayaran = tanggal_pembayaran;
    }

    public String getJumlah_bayar() {
        return jumlah_bayar;
    }

    public void setJumlah_bayar(String jumlah_bayar) {
        this.jumlah_bayar = jumlah_bayar;
    }

    public String getNama_siswa() {
        return nama_siswa;
    }

    public void setNama_siswa(String nama_siswa) {
        this.nama_siswa = nama_siswa;
    }

    public String getStatus_bayar() {
        return status_bayar;
    }

    public void setStatus_bayar(String status_bayar) {
        this.status_bayar = status_bayar;
    }
}
