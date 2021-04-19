package com.example.spusapp.Network;

public class CombineApi {
    public static final String BASE_URL = "http://192.168.43.184/spus/public/api/";
    public static final String img_url = "http://azharsiddiq.site/assets/img/upload/";
    public static final String THE_CAT_URL = "https://api.thecatapi.com/v1/";
    public static final String LOCATION_URL = "https://x.rajaapi.com/";
    public static ApiService getApiService(){
        return ApiClient.getApiClient(BASE_URL).create(ApiService.class);
    }
}
