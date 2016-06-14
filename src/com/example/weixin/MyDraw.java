package com.example.weixin;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jia on 2016/4/19.
 */
public class MyDraw extends View {
    public MyDraw(Context context, AttributeSet attrs){
        super(context,attrs);
    }
    protected void onDraw(Canvas canvas){
        /*Paint paint=new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);*/
       // canvas.drawLine(50,50,200,200,paint);
        //canvas.drawLines(new float[]{50,50,70,70,90,90,120,120,150,150,200,200},paint);
        //canvas.drawLines(new float[]{50,50,70,70,90,90,120,120,150,150,200,200},4,8,paint);
       // canvas.drawPoint(30,40,paint);
        //canvas.drawPoints(new float[]{30,30,45,50,69,70,100,100,120,120},paint);
        //canvas.drawPoints(new float[]{30,30,45,50,69,70,100,100,120,120},6,6,paint);
       // canvas.drawCircle(100,200,50,paint);
        //canvas.drawRect(200,300,600,500,paint);
       /* RectF rect=new RectF(200,300,500,500);
        canvas.drawRoundRect(rect,50,50,paint);*/
       // RectF rectF=new RectF(100,100,300,400);
        //canvas.drawOval(rectF,paint);
        //canvas.drawArc(rectF,45,135,true,paint);
        //canvas.drawArc(rectF,45,135,false,paint);
       /* Path linePath=new Path();
        linePath.moveTo(10,20);
        linePath.lineTo(140,100);
        linePath.lineTo(250,60);
        linePath.lineTo(150,30);
        linePath.lineTo(50,20);
        linePath.close();
        canvas.drawPath(linePath,paint);
        Path rectPath=new Path();
        int x=getMeasuredWidth()/2;
        int y=getMeasuredHeight()/2;
        RectF rectF=new RectF(x-200,y-200,x+200,y+200);
        rectPath.addRect(rectF,Path.Direction.CW);
        canvas.drawPath(rectPath,paint);
        Paint paint1=new Paint();
        paint1.setColor(Color.GREEN);
        paint1.setTextSize(30);
        String str="安卓学习课程，ASP.NET学习网站！";
        canvas.drawTextOnPath(str,rectPath,0,0,paint1);*/

        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(350,150,100,paint);
        this.invalidate();
        super.onDraw(canvas);

    }
}
