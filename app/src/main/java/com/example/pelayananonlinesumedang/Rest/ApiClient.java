package com.example.pelayananonlinesumedang.Rest;

import androidx.constraintlayout.solver.widgets.Chain;

import com.example.pelayananonlinesumedang.Model.GetJenisPelayanan;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static String authToken = "W9iaWxlOjFudDNuNS4yMDIw";
    private static Retrofit retrofit = null;
    public static Retrofit getClient(String BASE_URL){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }
    public static ApiInterface getDataService(String BASEURL){
        ApiInterface apiInterface = getClient(BASEURL).create(ApiInterface.class);
        return apiInterface;
    }
}

