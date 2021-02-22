package com.izzettinatug.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.imageView);
        TextView countryNameText = findViewById(R.id.countrynameText);
        TextView landmarkNameText = findViewById(R.id.landmarknameText);

        Intent intent = getIntent();
        String landmarknames = intent.getStringExtra("Names");
        landmarkNameText.setText(landmarknames);

        String countrynames =intent.getStringExtra("country");
        countryNameText.setText(countrynames);

        Singleton singleton = Singleton.getInstance();
        imageView.setImageBitmap(singleton.getChosenImage());



    }
}