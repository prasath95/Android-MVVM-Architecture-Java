package com.thunderboarsolution.MVVMretrofiltrequest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thunderboarsolution.MVVMretrofiltrequest.R;
import com.thunderboarsolution.MVVMretrofiltrequest.model.UserInfo;

import java.util.List;

public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.USerInfoViewholder> {
    private Context context;
    private List<UserInfo> list;

    public UserInfoAdapter(Context context, List<UserInfo> list) {
        this.context = context;
        this.list = list;
    }

    public void setUserInfoList(List<UserInfo> ulist)
    {
        this.list=ulist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public USerInfoViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.user_info_layout,parent,false);
        return new USerInfoViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull USerInfoViewholder holder, int position) {
        holder.tvbody.setText(""+list.get(position).getBody());
        holder.tvid.setText(""+list.get(position).getId());
        holder.tvtitle.setText(""+list.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        if(this.list!=null)
        {
            return this.list.size();
        }
        return 0;
    }

    public class USerInfoViewholder extends RecyclerView.ViewHolder {
        private TextView tvbody,tvid,tvtitle;

        public USerInfoViewholder(@NonNull View itemView) {
            super(itemView);

            tvbody=itemView.findViewById(R.id.textid);
            tvid=itemView.findViewById(R.id.tvid);
            tvtitle=itemView.findViewById(R.id.desciptionid);

        }
    }
}
