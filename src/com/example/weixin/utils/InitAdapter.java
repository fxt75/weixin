package com.example.weixin.utils;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.weixin.R;
import com.example.weixin.adapter.UsersAdapter;
import com.example.weixin.model.Users;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fan on 2016/5/12.
 */
public class InitAdapter {
    public static void initUserData(String result, ListView lv_fanxian, Context context) {
        try{
            Gson gson=new Gson();
            JsonParser parser=new JsonParser();
            JsonArray usersArray=new JsonArray();
            usersArray=parser.parse(result).getAsJsonArray();
            List<Users> list=new ArrayList<>();
            for(JsonElement element:usersArray){
                Users users=gson.fromJson(element,Users.class);
                list.add(users);
            }
            ArrayAdapter<Users> adapter=new UsersAdapter(context, R.layout.fanxian_item,list);
            lv_fanxian.setAdapter(adapter);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
