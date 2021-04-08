package com.example.spusapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.spusapp.Model.ResponseAnak;
import com.example.spusapp.R;

import java.util.List;

public class AnakAdapter extends ArrayAdapter<ResponseAnak> {
    List<ResponseAnak> responseAnakList;
    Context context;
    int layout;

    public AnakAdapter(Context context, int layout, List<ResponseAnak> responseAnakList){
        super(context,layout,responseAnakList);
        this.context = context;
        this.layout = layout;
        this.responseAnakList = responseAnakList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        AnakHolder holder;

        if (v == null){
            LayoutInflater vi = ((Activity)context).getLayoutInflater();
            v = vi.inflate(layout,parent,false);

            holder = new AnakHolder();
            holder.nama = (TextView) v.findViewById(R.id.tv_nama_anak);

            v.setTag(holder);
        } else{
            holder = (AnakHolder) v.getTag();
        }

        ResponseAnak responseAnak = responseAnakList.get(position);
        holder.nama.setText(responseAnak.getNama_siswa());

        return v;
    }

    private static class AnakHolder {
        TextView nama;
    }
}
