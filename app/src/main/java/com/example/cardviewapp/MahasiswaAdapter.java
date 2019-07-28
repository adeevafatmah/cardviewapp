package com.example.cardviewapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder> {
    private Context mContext;
    private List<Mahasiswa> mhsList;

    public MahasiswaAdapter(Context mContext, List<Mahasiswa> mhsList){
        this.mContext = mContext;
        this.mhsList = mhsList;
    }

    @NonNull
    @Override
    public  MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mahasiswa_card_item, parent, false);
        return new MahasiswaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaAdapter.MahasiswaViewHolder holder, int position)
    {
        final Mahasiswa mahasiswa = mhsList.get(position);
        holder.txtnim.setText(mahasiswa.getNim());
        holder.txtnama.setText(mahasiswa.getNama());

        Glide.with(mContext).load(mahasiswa.getPhoto()).into(holder.thumbnail);
        holder.thumbnail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(mContext, mahasiswa.getNama()+ "Clicked",
                        Toast.LENGTH_LONG).show();
            }

        });
    }

    @Override
    public int getItemCount() {
        return mhsList.size();
    }
    public class MahasiswaViewHolder extends RecyclerView.ViewHolder{
        private TextView txtnim, txtnama;
        private ImageView thumbnail;

        public MahasiswaViewHolder(@NonNull View view){
            super(view);
            txtnim = (TextView)view.findViewById(R.id.nim);
            txtnama = (TextView)view.findViewById(R.id.nama);
            thumbnail = (ImageView)view.findViewById(R.id.thumbnail);
        }
    }
}

