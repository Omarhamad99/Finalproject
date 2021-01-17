package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.example.finalproject.module.Adappter;
import com.example.finalproject.module.Cars;
import com.example.finalproject.module.CarsDetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List <Cars> carlist;
    private final String url ="http://192.168.56.1/get_data.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        carlist =new ArrayList<>();
        setContentView(R.layout.activity_main);
        Load();
        RecyclerView recycler = (RecyclerView)findViewById(R.id.cars_recycler);
        String caption [] = new String[carlist.size()];
        int [] ids = new int [carlist.size()];
        for (int i=0 ;i<caption.length ; i++){
            caption[i]=carlist.get(i).getName();
            ids[i]=Integer.parseInt(carlist.get(i).getImg());
        }
        recycler.setLayoutManager(new LinearLayoutManager(this));
        Adappter adappter = new Adappter(ids,caption);
        recycler.setAdapter(adappter);
    }


    public void cardOnclick(View view){

        System.out.println("hiiiii");

        String Des="";
        String name="";
        int imgid =0;
        int id = view.getId();
        for (int i=0 ; i<carlist.size();i++){
            if (id==Integer.parseInt(carlist.get(i).getImg())){
                Des =carlist.get(i).getDescreption();
                imgid=Integer.parseInt(carlist.get(i).getImg());
                name=carlist.get(i).getName();
            }
        }
        Intent intent = new Intent(getApplicationContext(), CarsDetails.class);
        intent.putExtra("desc",Des);
        intent.putExtra("id",imgid);
        intent.putExtra("name",name);
        startActivity(intent);

    }

    public void Load() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray array = new JSONArray(response);


                            for (int i = 0; i < array.length(); i++) {


                                JSONObject cars = array.getJSONObject(i);


                                int id =(int)cars.get("id");
                                String name =(String)cars.get("name");
                                String descreption = (String)cars.get("descrebtion");
                                String img = "R.drawable."+(String)cars.get("image");
                                carlist.add(new Cars(id,name,descreption,img));
                            }



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}