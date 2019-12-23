package com.sightcorner.www.ext.basic;

import java.util.Scanner;

/**
 * Created by Aaron Zheng<br>
 * Created at 22/12/2019<br>
 * Purpose <br>
 * fucheng.zheng@gmail.com<br>
 * <p>
 * Hisotry
 * <p>
 * 1.0 22/12/2019
 */
public class DrawSquare {

    /**
     * 根据输入的值，画出多个嵌套正方形
     *
     * @param args
     */
    public static void main(String[] args) {
        //1[8]-5[6]-9[4]-13[2]-17[0]
        //
        int num = 17;
        String[][] square = new String[17][17];
        for(int i = 0; i < num; i++) {
            for(int j = 0; j < num; j++) {
                square[i][j] = " ";
            }
        }
        for(int i = 0; i < (num/4+1); i++) {
            for(int m = i * 2; m < num - i * 2; m++) {
                square[i * 2][m] = "*";
                square[num - i * 2 - 1][m] = "*";

                square[m][i * 2] = "*";
                square[m][num - i * 2 - 1] = "*";
            }


        }

        for(int i = 0; i < num; i++) {
            for(int j = 0; j < num; j++) {
                System.out.print(square[i][j]);
            }
            System.out.println();
        }
    }


}
