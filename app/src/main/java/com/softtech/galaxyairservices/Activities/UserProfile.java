package com.softtech.galaxyairservices.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.softtech.galaxyairservices.R;

import org.json.JSONException;
import org.json.JSONObject;

import static android.content.ContentValues.TAG;

public class UserProfile extends AppCompatActivity {

    int  getUserID;
    String str_url = "http://galaxyairservices.com/testgalaxy/api/viewUserDetailsById?id=" ;

    TextView txt_name, txt_cnic, txt_email, txt_mobile, txt_memberType;
    ImageView imageView;
    private RequestQueue requestQueue;

    int int_id;
    String str_name, str_email, str_mobile, str_cnic, str_bankAccountNumber, str_salary, str_image;
    String str_registrationDate, str_email_verified_at, str_created_at, str_updated_at, str_user_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove Action Bar
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        setContentView(R.layout.activity_user_profile);

        txt_name = findViewById(R.id.id_name);
        txt_cnic = findViewById(R.id.id_cinc);
        txt_email = findViewById(R.id.id_email);
        txt_mobile = findViewById(R.id.id_phoneNumber);
        txt_memberType = findViewById(R.id.id_usertype);

        imageView = findViewById(R.id.id_imageView);

        SharedPreferences prefs = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE);
        getUserID = prefs.getInt("idUser", 0);

        requestQueue = Volley.newRequestQueue(UserProfile.this);
        parseJson(str_url+getUserID, true);
    }

    private void parseJson(final String str_url, final Boolean swipeRefresh) {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, str_url, null,
                new com.android.volley.Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        // pullToRefresh.setRefreshing(false);
                      //  mProgressBar.setVisibility(View.GONE);

                        // List<GetterSetter_Movies> movieList = listModel.getData().getMovies();
                        try {

                            JSONObject jsonObject = response.getJSONObject("user");

                            int_id = jsonObject.getInt("id");
                            str_name = jsonObject.getString("name");
                            str_email = jsonObject.getString("email");
                            str_mobile = jsonObject.getString("mobile");
                            str_cnic = jsonObject.getString("cnic");
                            str_bankAccountNumber = jsonObject.getString("bankAccountNumber");
                            str_salary = jsonObject.getString("salary");
                            str_image = jsonObject.getString("image");
                            str_registrationDate = jsonObject.getString("registrationDate");
                            str_created_at = jsonObject.getString("created_at");
                            str_updated_at = jsonObject.getString("updated_at");
                            str_user_type = jsonObject.getString("user_type");


                            txt_name.setText(str_name);
                            txt_cnic.setText(str_cnic);
                            txt_email.setText(str_email);
                            txt_mobile.setText(str_mobile);
                            txt_memberType.setText(str_user_type);

                         //   strImage = hotel.getHotel_pic();
                            String string_image = "http://www.galaxyairservices.com/public/uploads/"+str_image;

                            if ( str_image == null) {
                                Glide.with(UserProfile.this).load(R.mipmap.ic_launcher_round).into(imageView);
                                Log.d("Adapter Data Is Null", "");
                            } else {

                                Glide.with(UserProfile.this)
                                        .load(string_image)
                                        //.load("http://via.placeholder.com/300.png")
                                        .into(imageView);
                               // Log.d("Showing Images", hotel.getHotel_pic());
                            }

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
        // MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);

        requestQueue.add(jsonObjectRequest);
        requestQueue.cancelAll(TAG);
    }
}
