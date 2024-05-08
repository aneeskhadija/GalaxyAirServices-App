package com.softtech.galaxyairservices.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.softtech.galaxyairservices.Adapaters.Installment_Adapter;
import com.softtech.galaxyairservices.Models.GetterSetter;
import com.softtech.galaxyairservices.R;
import com.softtech.galaxyairservices.WebServices.InstallmentResponse;
import com.softtech.galaxyairservices.WebServices.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Installment extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar mProgressBar;
    Installment_Adapter adapter;
    private List<GetterSetter> listInstallment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_installment);

        SharedPreferences prefs = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE);
        int getUserID = prefs.getInt("idUser", 0);

        recyclerView = findViewById(R.id.id_recyclerView_installment);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        recyclerView.setLayoutManager(new LinearLayoutManager(Installment.this));

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter( adapter );
        mProgressBar.setVisibility(View.VISIBLE);

        Call<InstallmentResponse> call = RetrofitClient.getInstance().getApi().getInstallmentList(getUserID);

        call.enqueue(new Callback<InstallmentResponse>() {
            @Override
            public void onResponse(Call<InstallmentResponse> call, Response<InstallmentResponse> response) {

                mProgressBar.setVisibility(View.GONE);

                listInstallment = response.body().getPayment();
                adapter = new Installment_Adapter(getApplicationContext(),listInstallment);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<InstallmentResponse> call, Throwable t) {

            }
        });
    }
}
