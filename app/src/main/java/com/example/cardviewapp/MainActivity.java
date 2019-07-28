package com.example.cardviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MahasiswaAdapter adapter;
    private List<Mahasiswa> mhsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mhsList = new  ArrayList<>();
        adapter = new MahasiswaAdapter(this, mhsList);

        RecyclerView.LayoutManager mLayoutManager = new
                GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        preparedData();
    }

    private void preparedData() {
        int[] photos = new int[]{
                R.drawable.photo1,
                R.drawable.photo2,
                R.drawable.photo3,
                R.drawable.photo4,
                R.drawable.photo5,
                R.drawable.photo6
        };
        mhsList.add(new Mahasiswa("10001", "Andre", photos[0]));
        mhsList.add(new Mahasiswa("10002", "Afrizal", photos[1]));
        mhsList.add(new Mahasiswa("10003", "Azis", photos[2]));
        mhsList.add(new Mahasiswa("10004", "Indri", photos[3]));
        mhsList.add(new Mahasiswa("10005", "Adita", photos[4]));
        mhsList.add(new Mahasiswa("10006", "Maulana", photos[5]));

        adapter.notifyDataSetChanged();

    }
}
