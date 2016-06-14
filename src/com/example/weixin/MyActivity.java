package com.example.weixin;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.example.weixin.wxmain.FragmentFaxian;
import com.example.weixin.wxmain.FragmentTongxunlu;
import com.example.weixin.wxmain.FragmentWeixin;
import com.example.weixin.wxmain.FragmentWo;

public class MyActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
    FragmentWeixin f_weixin=null;
    FragmentTongxunlu f_tongxunlu=null;
    FragmentFaxian f_faxian=null;
    FragmentWo f_wo=null;
    RadioGroup rdgroup;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        rdgroup=(RadioGroup)findViewById(R.id.rdgroup);
        rdgroup.setOnCheckedChangeListener(this);
        f_weixin=new FragmentWeixin();
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_container,f_weixin).commit();
    }
    public void onCheckedChanged(RadioGroup radioGroup,int id){
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right);
        if(id==R.id.weixin){
            if(f_weixin==null)
                f_weixin=new FragmentWeixin();
            ft.replace(R.id.fl_container, f_weixin).commit();
        }
        if(id==R.id.tongxunlu){
            if(f_tongxunlu==null)
                f_tongxunlu=new FragmentTongxunlu();
            ft.replace(R.id.fl_container,f_tongxunlu).commit();
        }
        if(id==R.id.faxian){
            if(f_faxian==null)
                f_faxian=new FragmentFaxian();
            ft.replace(R.id.fl_container,f_faxian).commit();
        }
        if(id==R.id.wo){
            if(f_wo==null)
                f_wo=new FragmentWo();
            ft.replace(R.id.fl_container,f_wo).commit();
        }
    }
}
