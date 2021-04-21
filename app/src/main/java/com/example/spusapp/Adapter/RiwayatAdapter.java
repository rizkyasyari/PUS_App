package com.example.spusapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spusapp.Model.ResponseRiwayat;
import com.example.spusapp.R;

import java.util.List;

public class RiwayatAdapter extends RecyclerView.Adapter<RiwayatAdapter.ViewAdapter> {

    private List<ResponseRiwayat> responseRiwayatList;

    public RiwayatAdapter(List<ResponseRiwayat> responseRiwayatList){
        this.responseRiwayatList = responseRiwayatList;
    }

    public class ViewAdapter extends RecyclerView.ViewHolder {
        public TextView tvJudul,tvTanggal,tvNamaSiswa,tvJumlahBayar,tvStatusBayar;
        public ViewAdapter(@NonNull View itemView) {
            super(itemView);
            tvJudul = itemView.findViewById(R.id.tv_satu);
            tvTanggal = itemView.findViewById(R.id.tv_deskripsi);
            tvNamaSiswa = itemView.findViewById(R.id.tv_nama_siswa);
            tvJumlahBayar = itemView.findViewById(R.id.tv_total_pay);
            tvStatusBayar = itemView.findViewById(R.id.tv_status_bayar);
        }
    }

    @NonNull
    @Override
    public RiwayatAdapter.ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_view, parent, false);
        return new ViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RiwayatAdapter.ViewAdapter holder, int position) {
        holder.tvJudul.setText("Pembayaran "+responseRiwayatList.get(position).getNama_pembayaran()+" "+responseRiwayatList.get(position).getJenis_pembayaran());
        holder.tvNamaSiswa.setText(responseRiwayatList.get(position).getNama_siswa());
        holder.tvTanggal.setText(responseRiwayatList.get(position).getTanggal_pembayaran());
        holder.tvJumlahBayar.setText(responseRiwayatList.get(position).getJumlah_bayar());
        holder.tvStatusBayar.setText(responseRiwayatList.get(position).getStatus_bayar());
    }

    @Override
    public int getItemCount() {
        return responseRiwayatList.size();
    }

}
