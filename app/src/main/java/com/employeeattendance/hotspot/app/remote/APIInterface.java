package com.employeeattendance.hotspot.app.remote;


import com.employeeattendance.hotspot.app.modal.auth.VerifyPhoneModal;
import com.employeeattendance.hotspot.app.modal.auth.VerifyPhoneRequest;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface APIInterface {
    @POST("verify-phone")
    Call<VerifyPhoneModal> doCheckMobileStatus(@Header("Content-Type") String con_type, @Body VerifyPhoneRequest request);

//    @POST("verify-phone")
//    Call<VerifyPhoneModal> doVerifyPhoneStatus(@Header("Content-Type") String con_type, @Field("phone") String phone);

    @POST("verify-phone")
    Call<VerifyPhoneModal> doVerifyPhoneStatus(@Header("Content-Type")String contype,
                                               @Header("x-api-key")String header,
                                               @Header("Authorization")String author,
                                               @Body RequestBody body);
}
