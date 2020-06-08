package com.employeeattendance.hotspot.app.ui.auth;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.employeeattendance.hotspot.app.R;
import com.employeeattendance.hotspot.app.remote.APIInterface;
import com.employeeattendance.hotspot.app.remote.CustomNetwork;


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
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,)
    }
}
