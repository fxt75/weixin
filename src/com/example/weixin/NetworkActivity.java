package com.example.weixin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by fan on 2016/5/9.
 */
public class NetworkActivity extends Activity {
    ProgressBar pb_load;
    Button btn_pbload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.network_img);
        final ImageView img_network=(ImageView)findViewById(R.id.img_network);
        if(isNetworkConnected(getApplicationContext())){
            Toast.makeText(getApplicationContext(),"当前网络可用",Toast.LENGTH_LONG).show();
        }else{
            //Toast.makeText(getApplicationContext(),"当前网络不可用",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(Settings.ACTION_SETTINGS);
            startActivity(intent);
        }
        final String imgUrl="http://i.imgur.com/tGbaZCY.jpg";
        //new NetworkAsyncTask(img_network).execute(imgUrl);

        pb_load=(ProgressBar)findViewById(R.id.pb_load);
        btn_pbload=(Button)findViewById(R.id.btn_pbload);
        btn_pbload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new NetworkAsyncTask(img_network).execute(imgUrl);
            }
        });

    }

    public static boolean isNetworkConnected(Context context){
        ConnectivityManager cm=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info=cm.getActiveNetworkInfo();
        if(info!=null){
            return info.isAvailable();
        }
        return false;
    }
    class NetworkAsyncTask extends AsyncTask<String,Integer,Bitmap>{
        ImageView img;
        public NetworkAsyncTask(ImageView img) {
            this.img=img;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pb_load.setVisibility(View.VISIBLE);
        }

        @Override
        protected Bitmap doInBackground(String... addresses) {
            InputStream is=null;
            Bitmap bitmap=null;
            try{
                URL url=new URL(addresses[0]);
                HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                is=connection.getInputStream();
                bitmap= BitmapFactory.decodeStream(is);
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                if(is!=null){
                    try{
                        is.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
            return bitmap;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if(bitmap!=null){
                img.setImageBitmap(bitmap);
            }
            pb_load.setVisibility(View.GONE);
        }


    }
}
