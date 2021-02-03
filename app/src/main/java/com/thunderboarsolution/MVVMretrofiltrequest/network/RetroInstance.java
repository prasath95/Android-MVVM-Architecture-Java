package com.thunderboarsolution.MVVMretrofiltrequest.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {
    public static String BASE_URL="https://jsonplaceholder.typicode.com/";   //posts";

    private static Retrofit retrofit;

    public static Retrofit getRetrofitClient()
    {
        if(retrofit==null)
        {
            retrofit =new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
