package com.example.weixin;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by fan on 2016/5/3.
 */
public class ThreadActivity extends Activity {
    int count=10;
    boolean loop=true;
    Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thread_activity);
        Button btn_thread_start=(Button)findViewById(R.id.btn_thread_start);
        btn_thread_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*new Thread(new Runnable() {
                    @Override
                    public void run() {
                       while(loop){
                           Log.v("count=",String.valueOf(count++));
                           try {
                               Thread.sleep(2000);
                           }catch(InterruptedException e){
                               e.printStackTrace();
                           }
                       }
                    }
                }).start();*/
                /*thread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(loop){
                            Log.v("count=",String.valueOf(count++));
                            try {
                                Thread.sleep(2000);
                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                    }
                });
                thread.start();*/
                /*thread=new Thread(new MyThread());
                thread.start();*/
                new MyThread().start();
            }
        });
        Button btn_thread_stop=(Button)findViewById(R.id.btn_thread_stop);
        btn_thread_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loop=false;
            }
        });
    }
    public void run() {
        while(loop){
            Log.v("count=",String.valueOf(count++));
            try {
                Thread.sleep(2000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    class MyThread extends Thread implements Runnable{
        @Override
        public void run() {
            while(loop){
                Log.v("count=",String.valueOf(count++));
                try {
                    Thread.sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}


