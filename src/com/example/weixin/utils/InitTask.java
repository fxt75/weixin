package com.example.weixin.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
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
public class InitTask extends AsyncTask<String,String,String> {
    ProgressBar pb_load;
    ListView lv_fanxian;
    Context context;
    public InitTask(ListView lv_fanxian, ProgressBar pb_load, Context context){
        this.lv_fanxian=lv_fanxian;
        this.pb_load=pb_load;
        this.context=context;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pb_load.setVisibility(View.VISIBLE);
    }

    @Override
    protected String doInBackground(String... addresses) {
        return HttpUtils.getString(addresses[0]);
    }


    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        InitAdapter.initUserData(result,lv_fanxian,context);

        pb_load.setVisibility(View.GONE);
    }

}