package com.example.weixin.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


/**
 * Created by fan on 2016/5/18.
 */
public class MyTestService extends IntentService{
    public MyTestService(){
        super("service-test");
    }
    public MyTestService(String name){
        super(name);
    }
    @Override
    protected void onHandleIntent(Intent intent) {
       try {
           Thread.sleep(5000);
       }catch (InterruptedException e){
           e.printStackTrace();
       }
        Log.v("value",intent.getStringExtra("mykey"));
        Log.v("service","启动service");
        Log.v("service","service自行处理");
    }
}
