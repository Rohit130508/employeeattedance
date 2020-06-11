package com.employeeattendance.hotspot.app.ApiEndPoint;


import com.employeeattendance.hotspot.app.Model.WebResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("/hot/api/authentication/login")
    @FormUrlEncoded
    Call<WebResponse> getLogin(@Header("Authorization") String auth_key,
                               @Header("X-API-KEY") String api_key,
                               @Field("password") String phone,
                               @Field("phone") String password);




    @POST("/hot/api/authentication/verify-phone")
    @FormUrlEncoded
    Call<WebResponse> getPhoneVerify(@Header("Authorization") String auth_key,
                                     @Header("X-API-KEY") String api_key,
                                     @Field("phone") String phone);


    @POST("/hot/api/authentication/registration")
    @FormUrlEncoded
    Call<WebResponse> getRegister(@Header("Authorization") String auth_key,
                                  @Header("X-API-KEY") String api_key,
                                  @Field("first_name") String firstname,
                                  @Field("last_name") String lastname,
                                  @Field("email") String email,
                                  @Field("phone") String phone,
                                  @Field("password") String password,
                                  @Field("user_type") String userType);





}
