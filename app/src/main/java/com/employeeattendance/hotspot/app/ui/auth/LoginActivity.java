package com.employeeattendance.hotspot.app.ui.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.employeeattendance.hotspot.app.ApiEndPoint.ApiInterface;
import com.employeeattendance.hotspot.app.ApiEndPoint.Apiclient;
import com.employeeattendance.hotspot.app.MainActivity;
import com.employeeattendance.hotspot.app.Model.WebResponse;
import com.employeeattendance.hotspot.app.R;
import com.employeeattendance.hotspot.app.StoreManager;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private TextView lblAccountLogin;
    private TextView textViewForgotPassword;
    private TextView textViewCreateAccount;
    private TextView lblRememberPassword;
    private TextInputEditText editTextMobileNo;
    private TextInputEditText editTextPassword;
    private TextInputLayout layoutPassword;
    private CheckBox checkBoxRememberPassword;
    private static ApiInterface mApiclient;
    Button login_here;
    Button signup;
    TextView forget;
    EditText login_number;
    EditText login_password;
    StoreManager storeManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        getSupportActionBar().setTitle("Login");
        login_here = findViewById(R.id.login_here);
        signup = findViewById(R.id.signup);
        forget = findViewById(R.id.forget);
        login_number = findViewById(R.id.login_number);
        login_password = findViewById(R.id.login_password);
        mApiclient = Apiclient.getClient(getApplicationContext());
        storeManager = new StoreManager(getApplicationContext());


        forget.setOnClickListener(v -> {
//            Intent intent = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
//            startActivity(intent);
        });
        signup.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
            startActivity(intent);
        });

        login_here.setOnClickListener(v -> {
            if(validate() == true) {
                postLoginData(getString(R.string.Auth_key),getString(R.string.Api_key),login_password.getText().toString(), login_number.getText().toString());
            }
        });


    }

    private void postLoginData(String Authkey,String Apikey,String password,String phone){
        mApiclient.getLogin(Authkey,Apikey,password, phone).enqueue(new Callback<WebResponse>() {

            @Override
            public void onResponse(Call<WebResponse> call, Response<WebResponse> response) {
                if (response.isSuccessful()) {
                    WebResponse webResponse = response.body();
                    Boolean status = webResponse.getStatus();
                    String msg = webResponse.getMessage();
                    System.out.println("message"+msg);
                    if (status == true) {
                        storeManager.setLoginStatus(true);
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(),"Wrong email or password",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<WebResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Something Went wrong.Please wait.",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public boolean validate() {

//        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        boolean valid = false;

        String Phone= login_number.getText().toString();
        String Password= login_password.getText().toString();
        if (Phone.isEmpty()) {
            valid = false;
            login_number.setError("Please enter valid mobile no");
        }
        else if (Phone.length()!= 10) {
            valid = false;
            login_number.setError("Please enter valid valid number");
            login_number.requestFocus();

        }
//        else if(!Phone.matches(emailPattern)){
//            valid = false;
//            login_email.setError("Please enter valid email");
//        }
//        else if (!Phone)
        else if (Password.isEmpty()) {
            valid = false;
            login_password.setError("Please enter valid password!");
            login_password.requestFocus();
        }
        else if (Password.length() < 5) {
            valid = false;
            login_password.setError("more than 5");
            login_password.requestFocus();

        } else {
            System.out.println("gycgcxgfcgfcgfc");
            valid = true;
        }

        return valid;
    }

    @Override
    public boolean onNavigateUp() {
        onBackPressed();
        return super.onNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}