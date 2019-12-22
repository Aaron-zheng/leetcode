package com.sightcorner.www.ext.classloader;

import com.alibaba.fastjson.JSON;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Aaron Zheng<br>
 * Created at 14/7/2019<br>
 * Purpose <br>
 * fucheng.zheng@gmail.com<br>
 * <p>
 * Hisotry
 * <p>
 * 1.0 14/7/2019
 */
public class ClassLoaderLoadingTest {


    public static void main(String[] args) throws Exception {
        //启动添加参数，jvm -verbose:class，会记录类加载和卸载日志
        //注意点，主要用protocol "file:" 就是协议
        URL url = new URL("file:/Users/zhengfucheng/Documents/github_workspace/leetcode/target/classes/");
        URLClassLoader classLoader = new URLClassLoader(new URL[]{url});
        //注意必须使用 全限制类名称

        while(true) {
            //
            if(classLoader == null) {
                break;
            }
            //
            Class clazz = classLoader.loadClass("com.sightcorner.www.ext.classloader.TestClassLoaderView");
            Object instance = clazz.newInstance();
//            System.out.println(instance.hashCode());
//            System.out.println(instance.getClass().getClassLoader());


            Thread.sleep(3000L);
            System.out.println();

            clazz = null;
            instance = null;
            classLoader = null;
        }


        System.gc();
        Thread.sleep(10000L);
    }
}
