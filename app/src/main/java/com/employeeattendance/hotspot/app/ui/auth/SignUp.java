package com.employeeattendance.hotspot.app.ui.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

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

    }



}