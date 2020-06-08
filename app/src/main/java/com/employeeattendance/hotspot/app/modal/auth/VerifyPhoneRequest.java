package com.employeeattendance.hotspot.app.modal.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerifyPhoneRequest {
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @SerializedName("phone")
    @Expose
    private String phone;
}
