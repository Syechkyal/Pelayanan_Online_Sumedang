package com.example.pelayananonlinesumedang.Rest;

public class UtilsApi {
    public static final String BASE_URL_API = "http://117.53.46.5/sid_sumedang/api/";

    // Mendeklarasikan Interface BaseApiService
    public static ApiInterface getAPIService(){
        return ApiClient.getClient(BASE_URL_API).create(ApiInterface.class);
    }
}
