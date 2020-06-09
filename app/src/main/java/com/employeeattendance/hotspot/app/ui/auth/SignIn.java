package com.employeeattendance.hotspot.app.ui.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.employeeattendance.hotspot.app.R;
import com.employeeattendance.hotspot.app.appconstants.AppUrl;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignIn extends AppCompatActivity {

    EditText edtNumber, edtPassword;
    String mobileNumber, password;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        edtNumber = findViewById(R.id.edtNumber);
        edtPassword = findViewById(R.id.edtPassword);
        edtNumber.setText(getIntent().getStringExtra("Number"));

        getExecuteLogin();
    }

    void getExecuteLogin()
    {
        mobileNumber = edtNumber.getText().toString();
        password = edtPassword.getText().toString();
        getAuthorizationDemo();
    }

    void getAuthorizationDemo() {

        String URL = AppUrl.VerifyPhone;

        StringRequest request = new StringRequest(Request.Method.POST, URL,
                response -> {

                    System.out.println("responce==>>"+response);
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        if (jsonObject.getBoolean("status"))
                        {
                            startActivity(new Intent(SignIn.this,SignIn.class)
                                    .putExtra("Number",mobileNumber));
                        }

                    }catch (Exception e){}
                },
                error -> {

                })
        {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();
                params.put("x-api-key", "25d55ad283aa400af464c76d713c07ad");
                params.put("Authorization", "Basic YWRtaW46YWRtaW5AaG90c3BvdA==");
                return params;
            }

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("phone", mobileNumber);
                return params;
            }

        };

        RequestQueue queue = Volley.newRequestQueue(SignIn.this);
        request.setRetryPolicy(new
                DefaultRetryPolicy(20 * 1000, 2,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);



    }



}