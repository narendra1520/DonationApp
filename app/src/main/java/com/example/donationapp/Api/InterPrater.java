package com.example.donationapp.Api;


import com.example.donationapp.POJO.CategoryRes;
import com.example.donationapp.POJO.CollDetailsRes;
import com.example.donationapp.POJO.CollRes;
import com.example.donationapp.POJO.DefaultRes;
import com.example.donationapp.POJO.LoginRes;
import com.example.donationapp.POJO.NGORes;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface InterPrater {

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

    @GET("/Donation/getCategory.php")
    Call<CategoryRes> getCategory();

    @GET("/Donation/getCategory2.php")
    Call<CategoryRes> getCategory2();

    @GET("/Donation/getColl.php")
    Call<CollRes> getcoll();

    @GET("/Donation/getNgoAll.php")
    Call<NGORes> getNgoALl();

    //pincode API calling
    Call<DefaultRes> getPinAddr(String s_pin);

    @FormUrlEncoded
    @POST("/Donation/getNgo.php")
    Call<NGORes> getNGO(
            @Field("type") String type
    );

    @FormUrlEncoded
    @POST("/Donation/getCollDetails.php")
    Call<CollDetailsRes> getCollDetails(
            @Field("tag") String tag
    );
}
