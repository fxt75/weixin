package com.example.weixin.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.weixin.R;
import com.example.weixin.model.Users;

import java.util.List;

/**
 * Created by Administrator on 2016/5/11.
 */
public class UsersAdapter extends ArrayAdapter<Users> {
    private class ViewHolder{
        TextView tv_uid,tv_uname,tv_upwd;
    }
    public UsersAdapter(Context context, int resource, List<Users> object) {
        super(context,resource,object);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Users users=getItem(position);
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView=inflater.inflate(R.layout.fanxian_item,parent,false);
            viewHolder.tv_uid=(TextView)convertView.findViewById(R.id.tv_uid);
            viewHolder.tv_uname=(TextView)convertView.findViewById(R.id.tv_uname);
            viewHolder.tv_upwd=(TextView)convertView.findViewById(R.id.tv_upwd);
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder)convertView.getTag();
        }
        TextView tv_uid=(TextView)convertView.findViewById(R.id.tv_uid);
        TextView tv_uname=(TextView)convertView.findViewById(R.id.tv_uname);
        TextView tv_upwd=(TextView)convertView.findViewById(R.id.tv_upwd);

        tv_uid.setText(users.getUid());
        tv_uname.setText(users.getUname());
        tv_upwd.setText(users.getUpwd());
        if(position%2==0){
            viewHolder.tv_uname.setText("abcd");
            viewHolder.tv_uname.setTextColor(Color.RED);
        }else{
            viewHolder.tv_uname.setTextColor(Color.WHITE);
        }
        return convertView;
    }
}
