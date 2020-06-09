package com.employeeattendance.hotspot.app.ui.auth;

import android.os.Bundle;
import android.widget.EditText;

import com.employeeattendance.hotspot.app.R;
import com.employeeattendance.hotspot.app.appconstants.Utils;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText edtNumber;
    private String mobileNumber;
//    public static Retrofit apiManager;
//    public static Retrofit apiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_login);

//        apiManager = RetrofitManager.getInstance();

        edtNumber = findViewById(R.id.edtNumber);
        findViewById(R.id.cardNavigate).setOnClickListener(v->  checkPhoneStatus());

    }

//    void getAuthorizationDemo() {
//
//        Utils.customProgress(LoginActivity.this,"Please Wait...");
//        String URL = AppUrl.VerifyPhone;
//
//        StringRequest request = new StringRequest(Request.Method.POST, URL,
//                response -> {
//
//                    Utils.customProgressStop();
//                    System.out.println("responce==>>"+response+""+mobileNumber);
//                    try {
//                        JSONObject jsonObject = new JSONObject(response);
//                        if (jsonObject.getBoolean("status"))
//                        {
//                            startActivity(new Intent(LoginActivity.this,SignIn.class)
//                            .putExtra("Number",mobileNumber));
//                        }
//                        else
//                        {
//                            startActivity(new Intent(LoginActivity.this,SignUp.class)
//                                    .putExtra("Number",mobileNumber));
//                        }
//
//                    }catch (Exception ignored){}
//                },
//                error -> {
//                    Utils.customProgressStop();
//
//                    System.out.println("err"+error.getMessage());
//
//                })
//        {
//
//            @Override
//            public Map<String, String> getHeaders() {
//                Map<String, String> headers = new HashMap<>();
//                headers.put("Content-Type", "multipart/form-data");
//                headers.put("x-api-key", "25d55ad283aa400af464c76d713c07ad");
//                headers.put("Authorization", "Basic YWRtaW46YWRtaW5AaG90c3BvdA==");
//                return headers;
//            }
//
//            @Override
//            protected Map<String,String> getParams(){
//                Map<String,String> params = new HashMap<>();
//                params.put("phone","9453284838");
//                return params;
//            }
//        };
//
//        RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
//        request.setRetryPolicy(new
//                DefaultRetryPolicy(20 * 1000, 2,
//                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//        queue.add(request);
//
//
//
//    }


    void getAuthorizationDemo()
    {
//        Call call = apiManager.doVerifyPhoneStatus();
    }
    void checkPhoneStatus()
    {
        mobileNumber = edtNumber.getText().toString().trim();

        if(Utils.isNetworkAvailable(LoginActivity.this))
        getAuthorizationDemo();

    }
}
