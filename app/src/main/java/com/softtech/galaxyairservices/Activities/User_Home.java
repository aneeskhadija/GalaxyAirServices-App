package com.softtech.galaxyairservices.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.softtech.galaxyairservices.R;

public class User_Home extends AppCompatActivity {

    LinearLayout Linear_hotel, Linear_group, Linear_installment, Linear_location, Linear_profile, Linear_contact;
    ImageView img_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove Action Bar
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        setContentView(R.layout.activity_user__home);

        img_logo = findViewById(R.id.id_logo);

        Glide.with(User_Home.this)
                .load("http://www.galaxyairservices.com/public/adminCss/images/galaxy.png")
                //.load("http://via.placeholder.com/300.png")
                .into(img_logo);

        SharedPreferences prefs = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE);
        final int getUserID = prefs.getInt("idUser", 0);

       // Toast.makeText(this, ""+getUserID, Toast.LENGTH_SHORT).show();

        Linear_hotel = findViewById(R.id.id_hotel);
        Linear_group = findViewById(R.id.id_group);
        Linear_installment = findViewById(R.id.id_installment);
        Linear_location = findViewById(R.id.id_location);
        Linear_profile = findViewById(R.id.id_profile);
        Linear_contact = findViewById(R.id.id_contact);

        Linear_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intn_hotelList = new Intent(User_Home.this, HotelList.class);
                startActivity(intn_hotelList);
            }
        });

        Linear_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intn_hotelList = new Intent(User_Home.this, GroupMemberList.class);
                startActivity(intn_hotelList);
            }
        });

        Linear_installment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intn_hotelList = new Intent(User_Home.this, Installment.class);
                startActivity(intn_hotelList);
            }
        });

        Linear_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intn_hotelList = new Intent(User_Home.this, MapsActivity.class);
                startActivity(intn_hotelList);
            }
        });

        Linear_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intn_userprofile = new Intent(User_Home.this, UserProfile.class);
                startActivity(intn_userprofile);
            }
        });

        Linear_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intn_hotelList = new Intent(User_Home.this, ContactUs.class);
                startActivity(intn_hotelList);

            }
        });

    }
}
