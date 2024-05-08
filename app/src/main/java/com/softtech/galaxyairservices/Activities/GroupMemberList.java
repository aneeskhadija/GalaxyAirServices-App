package com.softtech.galaxyairservices.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.softtech.galaxyairservices.Adapaters.GroupMembers_Adapter;
import com.softtech.galaxyairservices.Models.GetterSetter;
import com.softtech.galaxyairservices.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class GroupMemberList extends AppCompatActivity {


    RecyclerView recyclerView;
    GroupMembers_Adapter adapter;
    private ProgressBar mProgressBar;
    private List<GetterSetter> listGroupMember;
    private RequestQueue requestQueue;

    int  getUserID;
    String str_url = "http://galaxyairservices.com/api/getGroupMemebersByAUserID?id=54" ;
    int int_id, int_organization_id, int_group_id, int_hotel_id;
    String str_name, str_email, str_mobile, str_cnic, str_clientId;
    String str_bankAccountNumber, str_image, str_registrationDate, str_email_verified_at;
    String str_password, str_remember_token, str_created_at, str_updated_at, str_user_type, str_groupName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_member_list);

        SharedPreferences prefs = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE);
        getUserID = prefs.getInt("idUser", 0);

        //int id_a = 54;

    //    Toast.makeText(this, ""+getUserID, Toast.LENGTH_SHORT).show();



        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.id_recyclerView_GroupMembers);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        mProgressBar.setVisibility(View.VISIBLE);

        listGroupMember = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(GroupMemberList.this);
        parseJson(str_url, true);
    }
    private void parseJson(final String str_url, final Boolean swipeRefresh) {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, str_url, null,
                new com.android.volley.Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                       // pullToRefresh.setRefreshing(false);
                         mProgressBar.setVisibility(View.GONE);

                        // List<GetterSetter_Movies> movieList = listModel.getData().getMovies();
                        try {

                            JSONArray jsonArray = response.getJSONArray("groups");

                            for (int i = 0; i<jsonArray.length(); i++){

                                JSONObject jobj = jsonArray.getJSONObject(i);


                                int_id = jobj.getInt("id");
                               // int_organization_id = jobj.getString("organization_id");
                                int_group_id = jobj.getInt("group_id");
//                                int_hotel_id = jobj.getInt("hotel_id");

                                str_name = jobj.getString("name");
                                str_email = jobj.getString("email");
                                str_mobile = jobj.getString("mobile");
                                str_cnic = jobj.getString("cnic");
                                str_clientId = jobj.getString("clientId");
                                str_bankAccountNumber = jobj.getString("bankAccountNumber");
                                str_image = jobj.getString("image");
                                str_registrationDate = jobj.getString("registrationDate");
                                str_email_verified_at = jobj.getString("email_verified_at");
                                str_password = jobj.getString("password");
                                str_remember_token = jobj.getString("remember_token");
                                str_user_type = jobj.getString("user_type");
                                str_groupName = jobj.getString("groupName");

                                str_created_at = jobj.getString("created_at");
                                str_updated_at = jobj.getString("updated_at");

                                listGroupMember.add(new GetterSetter(int_id, int_organization_id, int_group_id, int_hotel_id, str_name, str_email,
                                        str_mobile, str_cnic, str_clientId, str_bankAccountNumber, str_image, str_registrationDate, str_email_verified_at,
                                        str_password, str_remember_token, str_user_type, str_groupName, str_created_at, str_updated_at));

                            }
                            adapter = new GroupMembers_Adapter(GroupMemberList.this,listGroupMember);
                            recyclerView.setAdapter(adapter);

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
