package com.sightcorner.www.algocasts;

/**
 * Created by Aaron Zheng<br>
 * Created at 25/2/2020<br>
 * Purpose <br>
 * fucheng.zheng@gmail.com<br>
 * <p>
 * Hisotry
 * <p>
 * 1.0 25/2/2020
 */
public class Algo1 {

    /**
     * 这个题目说的是，给你一个字符串，你要判断它是否是回文字符串。
     * 字符串里只考虑字母和数字，其它的字符可以无视。另外，对于字母，可以忽略大小写。
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isRecStr("raceaecar"));
        System.out.println(isRecStr("raceacar"));
        System.out.println(isRecStr("raceAecar"));
        System.out.println(isRecStr("raceaCar"));
    }

    private static boolean isRecStr(String str) {
        int i = 0;
        int j = str.length() - 1;
        while(true) {
            if(i > j) {
                break;
            }
            char head = str.charAt(i);
            char tail = str.charAt(j);
            if(!isNumericAlphabet(head) || !isNumericAlphabet(tail)) {
                return false;
            }
            if(ignoreCase(head) != ignoreCase(tail)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    private static char ignoreCase(char c) {
        if(c >= 'A' && c <= 'Z') return c += 32;
        return c;
    }

    private static boolean isNumericAlphabet(char c) {
        if(c >= 'a' && c <= 'z') return true;
        if(c >= 'A' && c <= 'Z') return true;
        if(c >= '0' && c <= '9') return true;
        return false;
    }
}
