package com.thunderboarsolution.MVVMretrofiltrequest.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.thunderboarsolution.MVVMretrofiltrequest.model.UserInfo;
import com.thunderboarsolution.MVVMretrofiltrequest.network.APIService;
import com.thunderboarsolution.MVVMretrofiltrequest.network.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserInfoViewModel extends ViewModel {
    private MutableLiveData<List<UserInfo>> userInfoList;

    public UserInfoViewModel() {
        userInfoList = new MutableLiveData<>();
    }

    public MutableLiveData<List<UserInfo>> getUSerinfoObserver()
    {
        return userInfoList;
    }

    public void makeAPIcall()
    {
        APIService apiService= RetroInstance.getRetrofitClient()
                .create(APIService.class);

        Call<List<UserInfo>> call=apiService.getUserDetails();

        call.enqueue(new Callback<List<UserInfo>>() {
            @Override
            public void onResponse(Call<List<UserInfo>> call, Response<List<UserInfo>> response) {
                userInfoList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<UserInfo>> call, Throwable t) {
                userInfoList.postValue(null);
            }
        });

    }
}
