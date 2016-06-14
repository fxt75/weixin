package com.example.weixin;

import com.example.weixin.model.Content;

import java.util.Comparator;

/**
 * Created by jia on 2016/4/18.
 */
public class LetterComparator implements Comparator<Content> {
    public int compare(Content o, Content t1) {
        return o.getLetter().compareTo(t1.getLetter());
    }
}
