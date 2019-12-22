package com.sightcorner.www.ext.string;

import com.alibaba.fastjson.JSON;

/**
 * Created by Aaron Zheng<br>
 * Created at 6/6/2019<br>
 * Purpose <br>
 * fucheng.zheng@gmail.com<br>
 * <p>
 * Hisotry
 * <p>
 * 1.0 6/6/2019
 */
public class StringUsage {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString("=".split("=")));
        System.out.println(JSON.toJSONString("===".split("=")));
        System.out.println(JSON.toJSONString("=123".split("=")));
        System.out.println(JSON.toJSONString("123=".split("=")));
        System.out.println(JSON.toJSONString("=".split("=",1)));
    }
}
