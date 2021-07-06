package com.example.weatherapi;

import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {

    private String apiKey = "04372f186bc1d9069e68018c5f73ad59";
    private String ville = "casablanca";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            String url ="api.openweathermap.org/data/2.5/weather?q="+ville+"appid="+ apiKey;
            new MyWeatherTask((MyWeatherTaskListener) this).execute(url);



        RequestQueue Requstqueue = Volley.newRequestQueue(MainActivity.this);
        String lien ="https://metaweather.com/api/location/search/?query=casablanca";

        JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.GET,lien, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "erreur de connexion...", Toast.LENGTH_SHORT).show();
            }
        });
        Requstqueue.add(stringRequest);
    }


}
