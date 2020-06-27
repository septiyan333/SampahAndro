package com.project.hi_trash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    Button jemput, riwayat, jadwal, poin, edukasi, profil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        jemput = (Button) findViewById(R.id.jemput);
        riwayat = (Button) findViewById(R.id.riwayat);
        jadwal = (Button) findViewById(R.id.jadwal);
        poin = (Button) findViewById(R.id.poin);
        edukasi = (Button) findViewById(R.id.edukasi);
        profil = (Button) findViewById(R.id.profil);

        jemput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),PenjemputanActivity.class));
            }
        });
        riwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),RiwayatActivity.class));
            }
        });
        jadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),JadwalActivity.class));
            }
        });
        poin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),PoinActivity.class));
            }
        });
        edukasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),EdukasiActivity.class));
            }
        });
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),ProfilActivity.class));
            }
        });
    }
}
