package com.example.spusapp.Adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spusapp.Model.ResponseAnak;
import com.example.spusapp.R;
import com.example.spusapp.Transaction.Product;
import com.example.spusapp.Transaction.ProductDetailActivity;
import com.example.spusapp.Transaction.ProductListActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AnakRutinAdapter extends RecyclerView.Adapter<AnakRutinAdapter.ViewAdapter>{

    private List<ResponseAnak> responseAnakList;

    public AnakRutinAdapter(List<ResponseAnak> responseAnakList) {
        this.responseAnakList = responseAnakList;
    }

    public class ViewAdapter extends RecyclerView.ViewHolder {
        public TextView tvNamaAnak;
        public LinearLayout llAnak;
        public ViewAdapter(@NonNull View itemView) {
            super(itemView);
            tvNamaAnak = itemView.findViewById(R.id.tv_nama_anak);
            llAnak = itemView.findViewById(R.id.ll_anak);
        }
    }

    @NonNull
    @Override
    public ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_anak, parent, false);
        return new ViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewAdapter holder, final int position) {
        holder.tvNamaAnak.setText(responseAnakList.get(position).getNama_siswa());
        holder.llAnak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("id",responseAnakList.get(position).getId_siswa());
                Intent intent = new Intent(holder.itemView.getContext(), ProductListActivity.class);
                intent.putExtra("idSiswa", responseAnakList.get(position).getId_siswa());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return responseAnakList.size();
    }


}
