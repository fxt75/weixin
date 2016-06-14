package com.example.weixin.wxmain;

import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import com.example.weixin.MyDraw;
import com.example.weixin.R;
import com.example.weixin.adapter.UsersAdapter;
import com.example.weixin.model.Users;
import com.example.weixin.utils.HttpUtils;
import com.example.weixin.utils.InitTask;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jia on 2016/4/14.
 */
public class FragmentFaxian extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.faxian,container,false);
    }
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ProgressBar pb_load=(ProgressBar)view.findViewById(R.id.pb_load);
        ListView lv_fanxian=(ListView)view.findViewById(R.id.lv_fanxian);
        String url="http://52.38.232.240:8080/jfinal_gradle/users";
        new InitTask(lv_fanxian,pb_load,getActivity()).execute(url);
    }

}
