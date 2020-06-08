package com.employeeattendance.hotspot.app.remote;

import com.employeeattendance.hotspot.app.appconstants.AppUrl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitManager {

    private static Retrofit retrofit;
    public static String BASE_URL = AppUrl.BaseUrl;

    public static Retrofit getInstance()
    {
        if(retrofit == null)
        {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(interceptor);
            httpClient.readTimeout(4, TimeUnit.HOURS);
            httpClient.writeTimeout(4,TimeUnit.HOURS);
            httpClient.connectTimeout(4,TimeUnit.MINUTES);
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }

}
