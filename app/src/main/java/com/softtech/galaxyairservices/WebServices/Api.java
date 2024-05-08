package com.softtech.galaxyairservices.WebServices;

import com.softtech.galaxyairservices.Adapaters.GroupMembersResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    // Register Page API
    @FormUrlEncoded
    @POST("register")
    Call<ResponseBody> userRegister(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("mobile") String mobile
            //@Field("user_type") String user_type
    );

    // Login Page API
    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );

    //Hotel List API
    @GET("hotel_list_id")
    Call<DataResponse> getHotels(
            @Query("id") int id
    );

    //Installment List API
    @GET("payment_list")
    Call<InstallmentResponse> getInstallmentList(
            @Query("id") int id
    );

    //Group Members List API
    @GET("getGroupMemebers")
    Call<GroupMembersResponse> getGroupMembersList(
            @Query("id") int id
    );
    
}
