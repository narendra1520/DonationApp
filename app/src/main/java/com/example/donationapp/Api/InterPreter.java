package com.example.donationapp.Api;


import com.example.donationapp.POJO.DefaultRes;
import com.example.donationapp.POJO.LoginRes;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface InterPreter {

    //user login
    @FormUrlEncoded
    @POST("/android/getUser.php")
    Call<LoginRes> Login(
            @Field("uname") String uname,
            @Field("pass") String pass

    );

    //image upload
    @Multipart
    @POST("/android/uploadImage2.php")
    Call<DefaultRes> uploadImage(
            @Part MultipartBody.Part file,
            @Part("id") RequestBody id
    );

    //pincode API calling
    Call<DefaultRes> getPinAddr(String s_pin);
}
