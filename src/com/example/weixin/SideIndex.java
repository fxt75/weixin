package com.example.weixin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.SectionIndexer;
import com.example.weixin.adapter.ContentAdapter;

/**
 * Created by jia on 2016/4/18.
 */
public class SideIndex extends View {
    char[] letters;
    private ListView lv_tongxunlu;
    SectionIndexer sectionIndexer;
    public SideIndex(Context context){
        super(context);
        initLetters();
    }
    public SideIndex(Context context,AttributeSet attrs){
        super(context,attrs);
        initLetters();
    }
    public SideIndex(Context context,AttributeSet attrs,int defStyleAttr){
        super(context,attrs,defStyleAttr);
        initLetters();
    }
    private void initLetters(){
        String str=new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        letters=str.toCharArray();
    }
    public void setListView(ListView listView){
        lv_tongxunlu=listView;
        ContentAdapter adapter=(ContentAdapter)listView.getAdapter();
        sectionIndexer=adapter;
    }
    public boolean onTouchEvent(MotionEvent event){
        super.onTouchEvent(event);
        int y=(int)event.getY();
        int index=y/(getMeasuredHeight()/letters.length);
        if(index>=letters.length){
            index=letters.length-1;
        }else if(index<0){
            index=0;
        }
        if(event.getAction()==MotionEvent.ACTION_DOWN||event.getAction()==MotionEvent.ACTION_MOVE){
            if(sectionIndexer==null){
                sectionIndexer=(SectionIndexer)lv_tongxunlu.getAdapter();
            }
            int position=sectionIndexer.getPositionForSection(letters[index]);
            if(position==-1){
                return true;
            }
            lv_tongxunlu.setSelection(position);
        }
       return true;
    }
    protected void onDraw(Canvas canvas){
        Paint paint=new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(26);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);
        float width=getMeasuredWidth()/2;
        if(letters.length>0){
            float height=getMeasuredHeight()/letters.length;
            for(int i=0;i<letters.length;i++){
                canvas.drawText(String.valueOf(letters[i]),width,(i+1)*height,paint);
            }
        }
        this.invalidate();
        super.onDraw(canvas);
    }
}
