package com.izzettinatug.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Data
        ListView listView = findViewById(R.id.listView);
        ArrayList <String> landmarkNames = new ArrayList<>();
        landmarkNames.add("Pisa");
        landmarkNames.add("Eiffel");
        landmarkNames.add("Colesseo");
        landmarkNames.add("London Bridge");
        landmarkNames.add("Bosphorus Bridge");

        ArrayList<String>  countryNames =new ArrayList<>();
        countryNames.add("Italy");
        countryNames.add("France");
        countryNames.add("Italy");
        countryNames.add("United Kingdom");
        countryNames.add("Türkiye");

        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.pisa);
        Bitmap eiffel = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.eiffel);
        Bitmap colesseo = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.colosseo);
        Bitmap londonbridge = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.londonbridge);
        Bitmap bosphorus = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.bosphorusbridge);

        ArrayList<Bitmap> landmarkImages = new ArrayList<>();
        landmarkImages.add(pisa);
        landmarkImages.add(eiffel);
        landmarkImages.add(colesseo);
        landmarkImages.add(londonbridge);
        landmarkImages.add(bosphorus);


        //ListView

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, landmarkNames);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //System.out.println(landmarkNames.get(position));
                //System.out.println(countryNames.get(position));

                Intent intent = new Intent((getApplicationContext()), DetailActivity.class);
                //intent.putExtra("name:", landmarkNames.get(position));
                intent.putExtra("country", countryNames.get(position));
                intent.putExtra("Names", landmarkNames.get(position));

                Singleton singleton = Singleton.getInstance();
                singleton.setChosenImage(landmarkImages.get(position));


                startActivity(intent);
            }
        });


    }
}