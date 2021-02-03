package com.thunderboarsolution.MVVMretrofiltrequest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.thunderboarsolution.MVVMretrofiltrequest.adapter.UserInfoAdapter;
import com.thunderboarsolution.MVVMretrofiltrequest.model.UserInfo;
import com.thunderboarsolution.MVVMretrofiltrequest.viewmodel.UserInfoViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<UserInfo> list;
    private UserInfoAdapter adapter;
    private UserInfoViewModel userInfoViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerviewid);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter=new UserInfoAdapter(this,list);
        recyclerView.setAdapter(adapter);

        userInfoViewModel=ViewModelProviders.of(this).get(UserInfoViewModel.class);
        userInfoViewModel.getUSerinfoObserver().observe(this, new Observer<List<UserInfo>>() {
            @Override
            public void onChanged(List<UserInfo> userInfos) {
                if(userInfos!=null)
                {
                    list=userInfos;
                    adapter.setUserInfoList(userInfos);
                }
            }
        });
        userInfoViewModel.makeAPIcall();








    }
}