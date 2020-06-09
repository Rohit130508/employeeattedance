package com.employeeattendance.hotspot.app.ui.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

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

public class SignUp extends AppCompatActivity {

    EditText edtPhone, edtFirstName, edtLastName, edtPassword, edtEmail;
    TextView txtSubmit;
    private String _phoneNum, _firstName, _lastName, _password, _email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initView();
    }

    void initView()
    {
        txtSubmit = findViewById(R.id.txtSubmit);

        edtPhone = findViewById(R.id.edtPhone);
        edtFirstName = findViewById(R.id.edtFirstName);
        edtLastName = findViewById(R.id.edtLastName);
        edtPassword = findViewById(R.id.edtPassword);
        edtEmail = findViewById(R.id.edtEmail);

        edtPhone.setText(getIntent().getStringExtra("Number"));

        txtSubmit.setOnClickListener(view -> getExecuteRegister());
    }


    void getExecuteRegister()
    {
        _phoneNum = edtPhone.getText().toString();
        _firstName = edtFirstName.getText().toString();
        _lastName = edtLastName.getText().toString();
        _password = edtPassword.getText().toString();
        _email = edtEmail.getText().toString();

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
                params.put("first_name", _firstName);
                params.put("last_name", _lastName);
                params.put("email", _email);
                params.put("password", _password);
                params.put("phone", _phoneNum);
                params.put("user_type", "marketing");
                return params;
            }

        };

        RequestQueue queue = Volley.newRequestQueue(SignUp.this);
        request.setRetryPolicy(new
                DefaultRetryPolicy(20 * 1000, 2,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);



    }

}