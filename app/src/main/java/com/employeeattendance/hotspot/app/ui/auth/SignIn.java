package com.employeeattendance.hotspot.app.ui.auth;

import android.os.Bundle;
import android.widget.EditText;

import com.employeeattendance.hotspot.app.R;

import androidx.appcompat.app.AppCompatActivity;

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

    }





}