package com.example.weixin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.weixin.model.Users;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.LogRecord;

/**
 * Created by Administrator on 2016/5/3.
 */
public class WelcomeActivity extends Activity {
    int count=10;
    boolean loop=true;
    Handler handler;
    private int recLen = 8;
    Timer timer = new Timer();
    Thread thread;
    Button btn_login, btn_reg, btn_query_id, btn_query_like, btn_query_all, btn_query_update, btn_query_delete;
    EditText et_uid, et_uname, et_upwd;
    TextView tv_skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        tv_skip=(TextView)findViewById(R.id.tv_skip);
        /*handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0x110) {
                    tv_skip.setText(String.valueOf(msg.arg1));
                    *//*Users users=(Users)msg.obj;
                    Log.v("users:",users.getUid()+" "+users.getUname()+" "+users.getUpwd());*//*
                }
               *//* if (msg.what == 0x120) {
                    Intent intent = new Intent(WelcomeActivity.this, MyActivity.class);
                    startActivity(intent);
                    finish();
                }*//*
            }
        };*/
       /* tv_skip.post(new Runnable() {
            @Override
            public void run() {
                tv_skip.setText("20");
                SystemClock.sleep(5000);
                tv_skip.setText("30");
            }
        });*/
        tv_skip.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv_skip.setText("20");
            }
        },5000);
       /* thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    //int count=10;
                    while(count>0){
                        *//*Users users=new Users("10001","zhang","123456");
                        Message msg=new Message();
                        msg.what=0x110;
                        msg.arg1=count;
                        msg.obj=users;
                        handler.sendMessage(msg);*//*
                        handler.sendEmptyMessage(0x110);
                        thread.sleep(1000);
                        count--;
                    }
                    Intent intent = new Intent(WelcomeActivity.this, MyActivity.class);
                    startActivity(intent);
                    finish();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
    });
        thread.start();*/
        //timer.schedule(task, 1000, 1000);
        /*Button btn_skip = (Button) findViewById(R.id.btn_skip);
        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (thread != null && thread.isAlive()) {
                    thread.interrupt();
                }
                Intent intent = new Intent(WelcomeActivity.this, MyActivity.class);
                startActivity(intent);
                finish();
            }
        });
        */
    }
    /*TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    recLen--;
                    tv_skip.setText(""+recLen);
                    if(recLen < 0){
                        timer.cancel();
                        tv_skip.setVisibility(View.GONE);
                    }
                    if(recLen==0){
                        Intent intent = new Intent(WelcomeActivity.this, MyActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });
        }
    };*/
}
