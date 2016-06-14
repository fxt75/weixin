package com.example.weixin.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by fan on 2016/5/12.
 */
public class HttpUtils {
     static  String getString(String address) {
        StringBuffer resultStr=null;
        InputStream is=null;
        try{
            resultStr=new StringBuffer();
            URL myurl=new URL(address);
            HttpURLConnection connection=(HttpURLConnection) myurl.openConnection();
            is=connection.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is,"UTF8"));
            String readStr="";
            while((readStr=br.readLine())!=null){
                resultStr.append(readStr);
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(is!=null){
                try{
                    is.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return resultStr.toString();
    }

}
