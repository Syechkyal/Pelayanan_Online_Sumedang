package com.example.pelayananonlinesumedang.Rest;

public class UtilsApi {
    public static final String BASE_URL_API = "http://10.0.2.2/mahasiswa/";

    // Mendeklarasikan Interface BaseApiService
    public static ApiInterface getAPIService(){
        return ApiClient.getClient(BASE_URL_API).create(ApiInterface.class);
    }
}
