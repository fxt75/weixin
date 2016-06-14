package com.example.weixin.wxmain;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.weixin.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jia on 2016/4/14.
 */
public class FragmentWo extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.wo,container,false);
    }
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        Button btn_alpha=(Button)view.findViewById(R.id.btn_alpha);
        Button btn_scale=(Button)view.findViewById(R.id.btn_scale);
        Button btn_rotate=(Button)view.findViewById(R.id.btn_rotate);
        Button btn_translate=(Button)view.findViewById(R.id.btn_translate);
        Button btn_loading=(Button)view.findViewById(R.id.btn_loading);
        final TextView tv_animation=(TextView)view.findViewById(R.id.tv_animation);
        final ImageView iv_animation=(ImageView)view.findViewById(R.id.iv_animation);
        //Animation alphaAnimation= AnimationUtils.loadAnimation(getActivity(),R.anim.alpha_animation);
        /*Animation alphaAnimation=AnimationUtils.loadAnimation(getActivity(),R.anim.alpha_animation);
        iv_animation.setAnimation(alphaAnimation);*/
        /*AlphaAnimation alphaAnimation=new AlphaAnimation(0.0f,1.0f);
        alphaAnimation.setDuration(3000);
        alphaAnimation.setRepeatCount(3);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        iv_animation.setAnimation(alphaAnimation);*/
        /*btn_alpha.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                AlphaAnimation alphaAnimation=new AlphaAnimation(0.0f,1.0f);
                alphaAnimation.setDuration(3000);
                alphaAnimation.setRepeatCount(3);
                alphaAnimation.setRepeatMode(Animation.REVERSE);
                iv_animation.setAnimation(alphaAnimation);
                return false;
            }
        });*/
        btn_alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator alphaAnimation=ObjectAnimator.ofFloat(iv_animation,View.ALPHA,0.0f,1.0f);
                alphaAnimation.setDuration(5000);
                alphaAnimation.setRepeatCount(3);
                alphaAnimation.setRepeatMode(Animation.REVERSE);
                alphaAnimation.start();

            }
        });
        btn_scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Animation scaleAnimatiom= AnimationUtils.loadAnimation(getActivity(),R.anim.scale_animation);
                //iv_animation.startAnimation(scaleAnimatiom);
                ObjectAnimator scaleAnimation=ObjectAnimator.ofFloat(iv_animation,View.SCALE_X,0.0f,2.0f,1.2f);
                scaleAnimation.setDuration(5000);
                scaleAnimation.start();
            }
        });
        btn_rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Animation rotateAnimatiom= AnimationUtils.loadAnimation(getActivity(),R.anim.scale_animation);
                //iv_animation.startAnimation(rotateAnimatiom);
                ObjectAnimator rotateAnimation=ObjectAnimator.ofFloat(iv_animation,View.ROTATION,0.0f,360.0f);
                rotateAnimation.setDuration(5000);
                rotateAnimation.start();
            }
        });
        btn_translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Animation translateAnimatiom= AnimationUtils.loadAnimation(getActivity(),R.anim.scale_animation);
                //iv_animation.startAnimation(translateAnimatiom);
                ObjectAnimator translateAnimation=ObjectAnimator.ofFloat(iv_animation,View.TRANSLATION_X,0.0f,300.0f,100.0f,200.0f,50.0f);
                translateAnimation.setDuration(5000);
                translateAnimation.start();
            }
        });
        btn_loading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AnimatorSet animatorSet=new AnimatorSet();
                ObjectAnimator scaleXAnimation=ObjectAnimator.ofFloat(iv_animation,View.SCALE_X,0.0f,2.0f,1.2f);
                scaleXAnimation.setDuration(5000);
                ObjectAnimator scaleYAnimation=ObjectAnimator.ofFloat(iv_animation,View.SCALE_Y,0.0f,2.0f,1.2f);
                scaleYAnimation.setDuration(5000);
                ObjectAnimator rgbanimation=ObjectAnimator.ofInt(tv_animation,"BackgroundColor",0xffff00ff,0xff00ffff,0xffffff00,0xffabc123,0xff667788,0xff8800ff,0xff008b8b);
                rgbanimation.setEvaluator(new ArgbEvaluator());
                rgbanimation.setDuration(5000);
                animatorSet.playTogether(scaleXAnimation,scaleYAnimation,rgbanimation);
                animatorSet.start();*/

                /*AnimatorSet animatorSet=new AnimatorSet();
                List<Animator> list=new ArrayList<Animator>();
                ObjectAnimator scaleXAnimation=ObjectAnimator.ofFloat(iv_animation,View.SCALE_X,0.0f,2.0f,1.2f);
                scaleXAnimation.setDuration(5000);
                ObjectAnimator scaleYAnimation=ObjectAnimator.ofFloat(iv_animation,View.SCALE_Y,0.0f,2.0f,1.2f);
                scaleYAnimation.setDuration(5000);
                ObjectAnimator rgbanimation=ObjectAnimator.ofInt(tv_animation,"BackgroundColor",0xffff00ff,0xff00ffff,0xffffff00,0xffabc123,0xff667788,0xff8800ff,0xff008b8b);
                rgbanimation.setEvaluator(new ArgbEvaluator());
                rgbanimation.setDuration(5000);
                list.add(scaleXAnimation);
                list.add(scaleYAnimation);
                list.add(rgbanimation);
                animatorSet.playTogether(list);
                animatorSet.start();*/

                AnimatorSet animatorSet=new AnimatorSet();
                animatorSet.playTogether(ObjectAnimator.ofFloat(tv_animation,View.SCALE_X,0,2,1).setDuration(5000),
                        ObjectAnimator.ofFloat(tv_animation,View.SCALE_Y,0,2,1).setDuration(5000),
                        ObjectAnimator.ofObject(tv_animation,"BackgroundColor",new ArgbEvaluator(),0xffff00ff,0xff00ffff,
                                0xffffff00,0xffabc123,0xff667788,0xff8800ff,0xff008b8b).setDuration(5000));
                animatorSet.start();

                iv_animation.setImageResource(R.drawable.loading_animation);
                AnimationDrawable animationDrawable=(AnimationDrawable)iv_animation.getDrawable();
                animationDrawable.start();
                /*ObjectAnimator rgbanimation=ObjectAnimator.ofInt(tv_animation,"BackgroundColor",0xffff00ff,0xff00ffff,0xffffff00,0xffabc123,0xff667788,0xff8800ff,0xff008b8b);
                rgbanimation.setEvaluator(new ArgbEvaluator());
                rgbanimation.setDuration(10000);
                rgbanimation.start();*/
            }
        });
    }
}
