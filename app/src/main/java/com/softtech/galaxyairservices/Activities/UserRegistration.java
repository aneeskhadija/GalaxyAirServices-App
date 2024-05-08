package com.softtech.galaxyairservices.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.softtech.galaxyairservices.R;
import com.softtech.galaxyairservices.WebServices.RetrofitClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRegistration extends AppCompatActivity {

    EditText edt_username, edt_email, edt_password, edt_mobile;
    Button btn_signup;
    private ProgressBar mProgressBar;
    String str_username, str_email, str_password, str_mobile, str_userType, str_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove Action Bar
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        setContentView(R.layout.activity_user_registration);

        edt_email = findViewById(R.id.id_edt_email);
        edt_username = findViewById(R.id.id_edt_name);
        edt_password = findViewById(R.id.id_edt_password);
        edt_mobile = findViewById(R.id.id_edt_mobile);
        btn_signup = findViewById(R.id.id_btn_signup);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str_email = edt_email.getText().toString();
                str_username = edt_username.getText().toString();
                str_password = edt_password.getText().toString();
                str_mobile = edt_mobile.getText().toString();

                if (edt_email.getText().length() == 0) {

                    edt_email.setError(" please Enter Email");
                }else if (edt_username.getText().length() == 0) {
                    edt_username.setError(" please Enter Name");

                }else if (edt_password.getText().length() == 0) {
                    edt_password.setError(" please Enter Password");

                }else if (edt_mobile.getText().length() == 0) {
                    edt_mobile.setError(" please Enter Mobile");

                }else if (isConnected()) {


                    mProgressBar.setVisibility(View.VISIBLE);

                   // str_userType = "user";

                    Call<ResponseBody> call = RetrofitClient
                            .getInstance()
                            .getApi()
                            .userRegister(str_email,str_username, str_password,str_mobile);

                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            mProgressBar.setVisibility(View.GONE);
                            JSONObject jobj= null;
                            try {

                                String jsonData = response.body().string();

                                jobj = new JSONObject(jsonData);
                                 String status = jobj.getString("status");

                                 if (status.equals("success")){

                                     str_message = jobj.getString("message");
                                     Toast.makeText(UserRegistration.this, ""+str_message, Toast.LENGTH_SHORT).show();

                                 }else{

                                     Toast.makeText(UserRegistration.this, "Try again!!!", Toast.LENGTH_SHORT).show();

                                 }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {

                            Toast.makeText(getApplication(), "Server Something Problem", Toast.LENGTH_LONG).show();

                        }
                    });

                }else {

                    Toast.makeText(getApplication(), "Net Connection Problem", Toast.LENGTH_LONG).show();
                    //return true;
                }

            }
        });
    }

    public boolean isConnected(){
        ConnectivityManager connMgr = (ConnectivityManager) getApplication().getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }
}
