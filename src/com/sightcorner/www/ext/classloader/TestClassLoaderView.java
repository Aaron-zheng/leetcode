package com.sightcorner.www.ext.classloader;

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
public class TestClassLoaderView {

    public static void main(String[] args) throws Exception{

        //null
        System.out.println(TestClassLoaderView.class.getClassLoader().loadClass("java.lang.String").getClassLoader());

        //sun.misc.Launcher$ExtClassLoader@29453f44
        System.out.println(TestClassLoaderView.class.getClassLoader().loadClass("com.sun.nio.zipfs.ZipCoder").getClassLoader());

        //null
        System.out.println(String.class.getClassLoader());

        //sun.misc.Launcher$AppClassLoader@7f31245a
        System.out.println(TestClassLoaderView.class.getClassLoader());

        //sun.misc.Launcher$ExtClassLoader@29453f44
        System.out.println(TestClassLoaderView.class.getClassLoader().getParent());

        //null
        System.out.println(TestClassLoaderView.class.getClassLoader().getParent().getParent());
    }
}
