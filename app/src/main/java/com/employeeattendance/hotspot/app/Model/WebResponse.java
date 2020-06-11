package com.employeeattendance.hotspot.app.Model;

import com.google.gson.annotations.SerializedName;


public class WebResponse<T> {
    @SerializedName("status")
    public Boolean status;

    @SerializedName("message")
    public String message;

    @SerializedName("data")
    public T data;



    public WebResponse(Boolean status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    }




