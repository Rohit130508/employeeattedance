package com.employeeattendance.hotspot.app.ui.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

import com.employeeattendance.hotspot.app.MainActivity;
import com.employeeattendance.hotspot.app.R;


public class OTPScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(
                R.layout.activity_o_t_p_screen);

        TextView textView = findViewById(R.id.txtResendOtp);
        SpannableString content = new SpannableString("Content");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textView.setText(content);

        findViewById(R.id.txtConfirmOTP).setOnClickListener(v -> startActivity(new Intent(this, MainActivity.class)));
    }
}
