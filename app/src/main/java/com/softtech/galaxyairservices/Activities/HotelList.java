package com.softtech.galaxyairservices.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.softtech.galaxyairservices.Adapaters.HotelList_Adapter;
import com.softtech.galaxyairservices.Models.GetterSetter;
import com.softtech.galaxyairservices.R;
import com.softtech.galaxyairservices.WebServices.DataResponse;
import com.softtech.galaxyairservices.WebServices.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotelList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar mProgressBar;
    HotelList_Adapter adapter;
    private List<GetterSetter> listHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_list);

        SharedPreferences prefs = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE);
        int getUserID = prefs.getInt("idUser", 0);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.id_hotels_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(HotelList.this));

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter( adapter );
        mProgressBar.setVisibility(View.VISIBLE);

        Call<DataResponse> call = RetrofitClient.getInstance().getApi().getHotels(getUserID);

        call.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {

                mProgressBar.setVisibility(View.GONE);

                listHotel = response.body().getHotels();
                adapter = new HotelList_Adapter(getApplicationContext(),listHotel);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {

            }
        });


    }
}
