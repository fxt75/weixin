package com.example.weixin.wxmain;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.example.weixin.LetterComparator;
import com.example.weixin.R;
import com.example.weixin.SideIndex;
import com.example.weixin.adapter.ContentAdapter;
import com.example.weixin.model.Content;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by jia on 2016/4/14.
 */
public class FragmentTongxunlu extends Fragment {
    private ListView lv_tongxunlu;
    SideIndex sindex;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.tongxunlu,container,false);
    }
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        lv_tongxunlu=(ListView)view.findViewById(R.id.lv_tongxunlu);
        sindex=(SideIndex)view.findViewById(R.id.sindex);
        List<Content> list=new ArrayList<>();
        Random random=new Random();
        String str=new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        for(int i=0;i<100;i++){
            char ch=str.charAt(random.nextInt(26));
            Content content=new Content(ch+"",""+ch+i);
            list.add(content);
        }
        Collections.sort(list,new LetterComparator());
        ContentAdapter adpater=new ContentAdapter(getActivity(),list);
        lv_tongxunlu.setAdapter(adpater);
        sindex.setListView(lv_tongxunlu);
    }
}
