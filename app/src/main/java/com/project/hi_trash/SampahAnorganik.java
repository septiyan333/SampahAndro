package com.project.hi_trash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SampahAnorganik extends AppCompatActivity {
    ImageButton imgbtnplastik, imgbtnkaleng, imgbtnkain, imgbtnkertas, imgbtnkardus;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_sampahanorganik);
        imgbtnplastik = (ImageButton) findViewById(R.id.imgbtnplastik);
        imgbtnkaleng = (ImageButton) findViewById(R.id.imgbtnkaleng);
        imgbtnkain = (ImageButton) findViewById(R.id.imgbtnkain);
        imgbtnkertas = (ImageButton)findViewById(R.id.imgbtnkertas);
        imgbtnkardus = (ImageButton)findViewById(R.id.imgbtnkardus);

        imgbtnplastik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Limbahplastik.class));
            }
        });
        imgbtnkaleng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Limbahkaleng.class));
            }
        });
        imgbtnkain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Limbahkain.class));
            }
        });
        imgbtnkertas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Limbahkertas.class));
            }
        });
        imgbtnkardus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Limbahkardus.class));
            }
        });
    }
}
