package com.example.spusapp.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spusapp.Model.ResponseAnak;
import com.example.spusapp.Model.ResponseTagihan;
import com.example.spusapp.R;
import com.example.spusapp.Transaction.ProductDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TagihanRutinAdapter extends RecyclerView.Adapter<TagihanRutinAdapter.ViewAdapter> {

    private List<ResponseTagihan> responseTagihanList;

    public TagihanRutinAdapter(List<ResponseTagihan> responseTagihanList) {
        this.responseTagihanList = responseTagihanList;
    }
    public class ViewAdapter extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private TextView tv_price;
        private CardView cv_tagihan;
        public ViewAdapter(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_price = itemView.findViewById(R.id.tv_price);
            cv_tagihan = itemView.findViewById(R.id.cv_tagihan);
        }
    }

    @NonNull
    @Override
    public ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_products, parent, false);
        return new ViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewAdapter holder, final int position) {
        holder.tv_name.setText(responseTagihanList.get(position).getNama_pembayaran());
        holder.tv_price.setText("Rp "+responseTagihanList.get(position).getJumlah_bayar());
        holder.cv_tagihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ProductDetailActivity.class);
                intent.putExtra("name", responseTagihanList.get(position).getNama_pembayaran());
                intent.putExtra("price", responseTagihanList.get(position).getJumlah_bayar());
                intent.putExtra("qty", 1);
                intent.putExtra("position", position);
                intent.putExtra("id_tagihan", responseTagihanList.get(position).getId_tagihan());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return responseTagihanList.size();
    }

}
