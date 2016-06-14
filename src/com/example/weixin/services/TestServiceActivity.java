package com.example.weixin.services;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.example.weixin.R;

/**
 * Created by fan on 2016/5/18.
 */
public class TestServiceActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_view);
        final Button btn_start_service=(Button)findViewById(R.id.btn_start_service);
        btn_start_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchMyService();
                Log.v("msg","5秒之后执行");
                btn_start_service.setText("启动我的service");
            }
        });
    }
    protected void launchMyService(){
        Intent intent=new Intent(this,MyTestService.class);
        intent.putExtra("mykey","myValue");
        startService(intent);
    }
}
