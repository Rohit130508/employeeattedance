package com.employeeattendance.hotspot.app.remote;


import com.employeeattendance.hotspot.app.modal.auth.VerifyPhoneModal;
import com.employeeattendance.hotspot.app.modal.auth.VerifyPhoneRequest;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface APIInterface {




    @POST("verify-phone")
    Call<VerifyPhoneModal> doCheckMobileStatus(@Header("Content-Type") String con_type, @Body VerifyPhoneRequest request);

//    @POST("verify-phone")
//    Call<VerifyPhoneModal> doVerifyPhoneStatus(@Header("Content-Type") String con_type, @Field("phone") String phone);

    @Headers({
            "Accept: application/json",
            "X-API-KEY: 25d55ad283aa400af464c76d713c07ad",
            "Authorization: Basic YWRtaW46YWRtaW5AaG90c3BvdA=="
    })
    @POST("verify-phone")
    Call<VerifyPhoneModal> doVerifyPhoneStatus( @Field("phone") String phone);
}
