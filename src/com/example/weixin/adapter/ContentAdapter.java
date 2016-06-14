package com.example.weixin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.example.weixin.R;
import com.example.weixin.model.Content;

import java.util.List;

/**
 * Created by jia on 2016/4/18.
 */
public class ContentAdapter extends BaseAdapter implements SectionIndexer{
    private List<Content> list;
    private Context context;
    private ViewHolder viewHolder;
    private static class ViewHolder{
        TextView tv_letter;
        TextView tv_name;
    }
    public ContentAdapter(Context context,List<Content> list){
        this.context=context;
        this.list=list;
    }
    public int getCount(){
        return list.size();
    }
    public Object getItem(int i){
        return null;
    }
    public long getItemId(int i){
        return 0;
    }

    @Override
    public Object[] getSections() {
        return new Object[0];
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
       Content content;
        String letter;
        for(int k=0;k<list.size();k++){
            content=list.get(k);
            letter=content.getLetter();
            if(letter.charAt(0)==sectionIndex){
                return k;
            }
        }
        return -1;
    }

    @Override
    public int getSectionForPosition(int i) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView= LayoutInflater.from(this.context).inflate(R.layout.tongxunlu_item,parent,false);
            viewHolder.tv_letter=(TextView)convertView.findViewById(R.id.tv_letter);
            viewHolder.tv_name=(TextView)convertView.findViewById(R.id.tongxunren_name);
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder)convertView.getTag();
        }
        Content content=list.get(position);
        if(position==0){
            viewHolder.tv_letter.setVisibility(View.VISIBLE);
            viewHolder.tv_letter.setText(content.getLetter());
        }else{
            String lastLetter=list.get(position-1).getLetter();
            if(content.getLetter().equals(lastLetter)){
                viewHolder.tv_letter.setVisibility(View.GONE);
            }else{
                viewHolder.tv_letter.setVisibility(View.VISIBLE);
                viewHolder.tv_letter.setText(content.getLetter());
            }
        }
        viewHolder.tv_name.setText(content.getName());
        return convertView;


    }
}
