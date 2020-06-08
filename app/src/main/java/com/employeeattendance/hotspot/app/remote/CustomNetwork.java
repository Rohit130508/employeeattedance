package com.employeeattendance.hotspot.app.remote;

public class CustomNetwork {
    private static CustomNetwork instance;
    private final APIInterface apiServices;

    private CustomNetwork() {
        apiServices = RetrofitManager.getInstance().create(APIInterface.class);
    }

    public static CustomNetwork getInstance() {
        if (instance==null){
            instance=new CustomNetwork();
        }
        return instance;
    }

    public APIInterface getApiServices() {
        return apiServices;
    }
}
