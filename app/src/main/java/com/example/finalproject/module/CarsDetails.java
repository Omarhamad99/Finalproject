package com.example.finalproject.module;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.finalproject.R;

public class CarsDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars_details);
        Intent intent = getIntent();
        String Descrip=intent.getStringExtra("desc");
        int id =intent.getIntExtra("id",0);
        Drawable drawable = ContextCompat.getDrawable(this,id);
        String Name=intent.getStringExtra("name");
        ImageView image = (ImageView)findViewById(R.id.car_image);
        image.setImageDrawable(drawable);
        TextView txtName= (TextView)findViewById(R.id.txtName2);
        TextView txtDesc= (TextView)findViewById(R.id.txtDesc);

        txtName.setText(Name);
        txtDesc.setText(Descrip);
    }
}