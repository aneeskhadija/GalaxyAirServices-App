package com.softtech.galaxyairservices.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
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

public class MainActivity extends AppCompatActivity {

    EditText edt_email, edt_password;
    Button btn_login;
    private CheckBox shw_password_checkbox;
    TextView txt_signUp;
    private ProgressBar mProgressBar;
    String str_get_username, str_get_password, str_message, str_Mobile, str_userName, str_email, str_email_verfied, str_created_at, str_updated_at, str_userType;
    Integer int_userId;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove Action Bar
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        setContentView(R.layout.activity_main);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        edt_email = findViewById(R.id.id_edt_email);
        edt_password = findViewById(R.id.id_edt_password);
        btn_login = findViewById(R.id.id_btn_login);
        txt_signUp = findViewById(R.id.id_not_a_member_sign_up_now);

        txt_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intnt_signup = new Intent(MainActivity.this, UserRegistration.class);
                startActivity(intnt_signup);
            }
        });

        /*....................... Show Password ........................*/
        /*shw_password_checkbox = findViewById(R.id.id_show_hide_password);
        shw_password_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // checkbox status is changed from uncheck to checked.
                if (!isChecked) {
                    // show password
                    edt_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    // hide password
                    edt_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });*/

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str_get_username = edt_email.getText().toString();
                str_get_password = edt_password.getText().toString();

                if (edt_email.getText().length() == 0) {

                    edt_email.setError(" please Enter Email");
                }else if (edt_password.getText().length() == 0) {
                    edt_password.setError(" please Enter Password");

                }else if (isConnected()) {


                    mProgressBar.setVisibility(View.VISIBLE);

                    Call<ResponseBody> call = RetrofitClient
                            .getInstance()
                            .getApi()
                            .userLogin(str_get_username, str_get_password);

                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            mProgressBar.setVisibility(View.GONE);
                            JSONObject jobj= null;
                            try {

                                String jsonData = response.body().string();

                                jobj = new JSONObject(jsonData);
                               // String status = jobj.getString("status");
                                str_message = jobj.getString("message");

                                if (str_message.equals("Login Successfull")){

                                    int_userId = jobj.getInt("userId");

                                    SharedPreferences.Editor editor = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE).edit();
                                   // editor.putString("name", "Elena");
                                    editor.putInt("idUser", int_userId);
                                    editor.apply();

                                    Intent intnt_user = new Intent(MainActivity.this, User_Home.class);
                                    startActivity(intnt_user);

                                }else {

                                    Toast.makeText(MainActivity.this, "Sorry!!! UnAuthorised", Toast.LENGTH_SHORT).show();
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
