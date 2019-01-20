package com.sightcorner.www.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron Zheng<br>
 * Created at 20/1/2019<br>
 * Purpose <br>
 * fucheng.zheng@gmail.com<br>
 * <p>
 * Hisotry
 * <p>
 * 1.0 20/1/2019
 */
/*

将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G
*/

public class ZigZagConversion {

    public static void main(String[] args) {
        System.out.println(new ZigZagConversion().convert("AB", 1));
        System.out.println(new ZigZagConversion().convert("LEETCODEISHIRING", 3));
        System.out.println(new ZigZagConversion().convert("LEETCODEISHIRING", 4));
    }


    public String convert(String s, int numRows) {

        if(numRows == 1) {
            return s;
        }


        List<String> list = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            list.add("");
        }
        boolean upgradeRow = true;
        int currentRow = 0;

        for(Character c : s.toCharArray()) {
            list.set(currentRow, list.get(currentRow) + c);

            if(upgradeRow) {
                currentRow++;
                if(currentRow == numRows) {
                    upgradeRow = false;
                    currentRow -= 2;
                }
            } else {
                currentRow--;

                if(currentRow == -1) {
                    upgradeRow = true;
                    currentRow += 2;
                }
            }
        }

        String result = "";
        for(String t : list) {
            result += t;
        }

        return result;
    }

}
