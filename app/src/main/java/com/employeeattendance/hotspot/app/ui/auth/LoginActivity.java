package com.employeeattendance.hotspot.app.ui.auth;

import android.content.Intent;
import android.os.Bundle;

import com.employeeattendance.hotspot.app.R;
import com.employeeattendance.hotspot.app.modal.auth.VerifyPhoneModal;
import com.employeeattendance.hotspot.app.remote.APIInterface;
import com.employeeattendance.hotspot.app.remote.CustomNetwork;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    APIInterface mAPIService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_login);

        mAPIService = CustomNetwork.getInstance().getApiServices();

        findViewById(R.id.cardNavigate).setOnClickListener(v-> startActivity(new Intent(this,OTPScreen.class)));
        checkPhoneStatus();

    }

    void checkPhoneStatus()
    {

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("phone", "9453284838")
                .build();
        final Call<VerifyPhoneModal> listCall = mAPIService.doVerifyPhoneStatus("multipart/form-data","25d55ad283aa400af464c76d713c07ad",
                "Basic YWRtaW46YWRtaW5AaG90c3BvdA==",
                requestBody);

        listCall.enqueue(new Callback<VerifyPhoneModal>() {
            @Override
            public void onResponse(Call<VerifyPhoneModal> call, Response<VerifyPhoneModal> response) {
                assert response.body() != null;
                System.out.println("respo==="+new Gson().toJson(response));

            }

            @Override
            public void onFailure(Call<VerifyPhoneModal> call, Throwable t) {
                t.printStackTrace();
                System.out.println("respo==="+t.getMessage());

            }
        });

    }
}
