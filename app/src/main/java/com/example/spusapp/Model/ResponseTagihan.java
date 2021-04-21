package com.example.spusapp.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseTagihan {
    @SerializedName("id_tagihan") String id_tagihan;
    @SerializedName("id_siswa") String id_siswa;
    @SerializedName("tanggal_tagihan") String tanggal_tagihan;
    @SerializedName("batas_akhir_pembayaran") String batas_akhir_pembayaran;
    @SerializedName("tanggal_pembayaran") String tanggal_pembayaran;
    @SerializedName("id_jenis_pembayaran") String id_jenis_pembayaran;
    @SerializedName("id_pembayaran") String id_pembayaran;
    @SerializedName("order_id") String order_id;
    @SerializedName("status_bayar") String status_bayar;
    @SerializedName("tanggal_bayar") String tanggal_bayar;
    @SerializedName("tipe_pembayaran") String tipe_pembayaran;
    @SerializedName("keterangan") String keterangan;
    @SerializedName("jenis_pembayaran") String jenis_pembayaran;
    @SerializedName("nama_pembayaran") String nama_pembayaran;
    @SerializedName("id_sekolah") String id_sekolah;
    @SerializedName("jumlah_bayar") Integer jumlah_bayar;
    @SerializedName("id_tahun_ajaran") String id_tahun_ajaran;

    @SerializedName("code") String code;
    @SerializedName("message") String message;

    public String getId_tagihan() {
        return id_tagihan;
    }

    public void setId_tagihan(String id_tagihan) {
        this.id_tagihan = id_tagihan;
    }

    public String getId_siswa() {
        return id_siswa;
    }

    public void setId_siswa(String id_siswa) {
        this.id_siswa = id_siswa;
    }

    public String getTanggal_tagihan() {
        return tanggal_tagihan;
    }

    public void setTanggal_tagihan(String tanggal_tagihan) {
        this.tanggal_tagihan = tanggal_tagihan;
    }

    public String getBatas_akhir_pembayaran() {
        return batas_akhir_pembayaran;
    }

    public void setBatas_akhir_pembayaran(String batas_akhir_pembayaran) {
        this.batas_akhir_pembayaran = batas_akhir_pembayaran;
    }

    public String getTanggal_pembayaran() {
        return tanggal_pembayaran;
    }

    public void setTanggal_pembayaran(String tanggal_pembayaran) {
        this.tanggal_pembayaran = tanggal_pembayaran;
    }

    public String getId_jenis_pembayaran() {
        return id_jenis_pembayaran;
    }

    public void setId_jenis_pembayaran(String id_jenis_pembayaran) {
        this.id_jenis_pembayaran = id_jenis_pembayaran;
    }

    public String getId_pembayaran() {
        return id_pembayaran;
    }

    public void setId_pembayaran(String id_pembayaran) {
        this.id_pembayaran = id_pembayaran;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getStatus_bayar() {
        return status_bayar;
    }

    public void setStatus_bayar(String status_bayar) {
        this.status_bayar = status_bayar;
    }

    public String getTanggal_bayar() {
        return tanggal_bayar;
    }

    public void setTanggal_bayar(String tanggal_bayar) {
        this.tanggal_bayar = tanggal_bayar;
    }

    public String getTipe_pembayaran() {
        return tipe_pembayaran;
    }

    public void setTipe_pembayaran(String tipe_pembayaran) {
        this.tipe_pembayaran = tipe_pembayaran;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

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

    public String getId_sekolah() {
        return id_sekolah;
    }

    public void setId_sekolah(String id_sekolah) {
        this.id_sekolah = id_sekolah;
    }

    public Integer getJumlah_bayar() {
        return jumlah_bayar;
    }

    public void setJumlah_bayar(Integer jumlah_bayar) {
        this.jumlah_bayar = jumlah_bayar;
    }

    public String getId_tahun_ajaran() {
        return id_tahun_ajaran;
    }

    public void setId_tahun_ajaran(String id_tahun_ajaran) {
        this.id_tahun_ajaran = id_tahun_ajaran;
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
