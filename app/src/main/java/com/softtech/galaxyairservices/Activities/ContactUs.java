package com.softtech.galaxyairservices.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.softtech.galaxyairservices.R;

public class ContactUs extends AppCompatActivity {

    ImageView img_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        img_view = findViewById(R.id.id_imageView);

        Glide.with(ContactUs.this)
                .load("http://www.galaxyairservices.com/public/adminCss/images/galaxy.png")
                //.load("http://via.placeholder.com/300.png")
                .into(img_view);
    }
}
