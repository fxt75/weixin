package com.example.weixin.model;

/**
 * Created by jia on 2016/4/18.
 */
public class Content {
    private String letter;
    private String name;
    private String img;
    public Content(){

    }
    public Content(String letter,String name){
        this.letter=letter;
        this.name=name;
    }
    public Content(String letter,String name,String img){
        this.letter=letter;
        this.name=name;
        this.img=img;
    }
    public String getLetter(){
        return letter;
    }
    public void setLetter(String letter){
        this.letter=letter;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getImg(){
        return img;
    }
    public void setImg(String img){
        this.img=img;
    }
}

