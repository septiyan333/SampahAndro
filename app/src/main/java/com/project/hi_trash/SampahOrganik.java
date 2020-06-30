package com.project.hi_trash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageButton;

public class SampahOrganik extends AppCompatActivity {
    ImageButton imgbtnminyak, imgbtnbuahsayur;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_sampahorganik);
        imgbtnminyak = (ImageButton) findViewById(R.id.imgbtnminyak);
        imgbtnbuahsayur = (ImageButton) findViewById(R.id.imgbtnbuahsayur);

        imgbtnminyak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Limbahminyak.class));
            }
        });
        imgbtnbuahsayur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Limbahsayur.class));
            }
        });
    }
}
