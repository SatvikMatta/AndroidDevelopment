package com.mattasatvik.volley;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import com.bumptech.glide.Glide;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {
    TextView nametext;
    List<String> jsonResponses;
    ImageView imageView;
    LocalDate today = LocalDate.now();
    int addDays;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_main);
        nametext = findViewById(R.id.name);
        imageView = findViewById(R.id.photo);
        addDays = 0;
        volleyGet();

    }



    @SuppressWarnings("deprecation")
    public static Drawable getUrlDrawable(String url) {
        try {
            URL aryURI = new URL(url);
            URLConnection conn = aryURI.openConnection();
            InputStream is = ((URLConnection) conn).getInputStream();
            Bitmap bmp = BitmapFactory.decodeStream(is);
            return new BitmapDrawable(bmp);
        } catch (Exception e) {
            return null;
        }
    }
    public void volleyGet() {
        String url = "https://api.nasa.gov/planetary/apod?api_key=KE2h8sOfAe2KIdgotNDciAfyOxprupOb7VLTke8l"+ "&date=" + today.plusDays(addDays);
        jsonResponses = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    try {
                        jsonResponses.add(response.getString("copyright"));
                    }
                    catch (Exception e){
                        jsonResponses.add("Unknown");
                    }
                    jsonResponses.add(response.getString("hdurl"));
                    nametext.setText("Photo Credit: "+ jsonResponses.get(0));
                    String imageUrl = jsonResponses.get(1);
                    Glide.with(getApplicationContext()).load(imageUrl).into(imageView);
                    nametext.setY(200);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    public void methodprev(View view) {
        addDays--;
        volleyGet();
    }

    public void methodnext(View view) {
        if (addDays < 0){
            addDays++;
        }
        else{
            Toast.makeText(getApplicationContext(), "Can't See the Future!", Toast.LENGTH_SHORT).show();
        }
        volleyGet();
    }
}