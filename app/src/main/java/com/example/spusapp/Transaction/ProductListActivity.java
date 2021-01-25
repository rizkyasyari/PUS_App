package com.example.spusapp.Transaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spusapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        init();
    }

    private void init() {
//        findViewById(R.id.image_setting_account).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(ProductListActivity.this, AccountActivity.class));
//            }
//        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);

        AdapterProduct adapterProduct = new AdapterProduct(DataCustumer.getListProduct());

        recyclerView.setAdapter(adapterProduct);
    }
    class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ProductViewHolder>{

        private List<Product> productList;

        public AdapterProduct(List<Product> productList) {
            this.productList = productList;
        }

        @NonNull
        @Override
        public AdapterProduct.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.item_products, parent, false);
            return new ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final AdapterProduct.ProductViewHolder holder, final int position) {

            Picasso.with(holder.itemView.getContext())
                    .load(productList.get(position).getImages())
                    .resize(150,150)
                    .into(holder.image_product);

            holder.tv_name.setText(productList.get(position).getName());
            holder.tv_price.setText("Rp "+productList.get(position).getPrice());
//            holder.tv_rating.setText(String.valueOf(productList.get(position).getRating()));
            holder.image_product.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(holder.itemView.getContext(), ProductDetailActivity.class);
                    intent.putExtra("image", productList.get(position).getImages());
                    intent.putExtra("name", productList.get(position).getName());
                    intent.putExtra("price", productList.get(position).getPrice());
//                    intent.putExtra("rating", productList.get(position).getRating());
                    intent.putExtra("qty", productList.get(position).getQty());
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
            });


        }

        @Override
        public int getItemCount() {
            return productList.size();
        }

        class ProductViewHolder extends RecyclerView.ViewHolder{

            private ImageView image_product;
            private TextView tv_name;
            private TextView tv_price;
            private TextView tv_rating;

            public ProductViewHolder(@NonNull View itemView) {
                super(itemView);
                image_product = itemView.findViewById(R.id.image_product);
                tv_name = itemView.findViewById(R.id.tv_name);
                tv_price = itemView.findViewById(R.id.tv_price);
//                tv_rating = itemView.findViewById(R.id.tv_rating);
            }
        }
    }
}
