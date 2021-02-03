package com.thunderboarsolution.MVVMretrofiltrequest.network;

import com.thunderboarsolution.MVVMretrofiltrequest.model.UserInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("posts")
    Call<List<UserInfo>> getUserDetails();

}
