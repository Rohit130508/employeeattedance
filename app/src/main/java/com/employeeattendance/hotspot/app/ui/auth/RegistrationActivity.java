package com.employeeattendance.hotspot.app.ui.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.employeeattendance.hotspot.app.ApiEndPoint.ApiInterface;
import com.employeeattendance.hotspot.app.ApiEndPoint.Apiclient;
import com.employeeattendance.hotspot.app.Model.WebResponse;
import com.employeeattendance.hotspot.app.R;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {
    EditText Username;
    EditText Email;
    EditText Phone;
    EditText SinupPass;
    EditText ConfirmPass;



    Button button_create;
    private static ApiInterface mApiclient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
//        getSupportActionBar().hide();
         Username = findViewById(R.id.edit_username);
//        EditText userlastname = (EditText) findViewById(R.id.userlastname);
        Email = findViewById(R.id.signup_email);
        Phone= findViewById(R.id.phone);
//        EditText repair= (EditText) findViewById(R.id.repair);
         SinupPass = findViewById(R.id.signup_pass);
        ConfirmPass = findViewById(R.id.confirm_pass);

        Button signup_here = findViewById(R.id.signup_here);
        Button login_page = findViewById(R.id.login_page);
        mApiclient = Apiclient.getClient(getApplicationContext());
        login_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
//        signup_here.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(RegistrationActivity.this,.class);
//                startActivity(intent);
//            }
//        });

//        Username.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(RegistrationActivity.this,PersonalDetailsActivity.class);
//                startActivity(i);
//            }
//        });
//        userlastname.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(RegistrationActivity.this,ServicesActivity.class);
//                startActivity(i);
//            }
//        });
//        Phone.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(RegistrationActivity.this, PancardDetailsActivity.class);
//                startActivity(i);
//            }
//        });
//        repair.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(RegistrationActivity.this,Bank.class);
//                startActivity(i);
//            }
//        });
//        SinupPass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(RegistrationActivity.this, AadharCardDetails.class);
//                startActivity(i);
//            }
//        });
//        ConfirmPass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(RegistrationActivity.this, GSTActivity.class);
//                startActivity(i);
//            }
//        });


        signup_here.setOnClickListener(v -> postRegisterData(getString(R.string.Auth_key),getString(R.string.Api_key),
                Username.getText().toString(),"cd",Email.getText().toString(),
                SinupPass.getText().toString(),
                Phone.getText().toString()));


    }


    private void postRegisterData(String Authkey,String Apikey,String fname,String lname,String email,String pass,String phone){
        mApiclient.getRegister(Authkey,Apikey,fname,lname,email,phone, pass, "marketing").enqueue(new Callback<WebResponse>()
        {
            @Override
            public void onResponse(Call<WebResponse> call, Response<WebResponse> response) {
                if (response.isSuccessful()) {
                    WebResponse webResponse = response.body();
                    Boolean status = webResponse.getStatus();
                    String msg = webResponse.getMessage();
                    if (status == true) {
                        Intent intent = new Intent(RegistrationActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<WebResponse> call, Throwable t) {

            }
        });
    }


}