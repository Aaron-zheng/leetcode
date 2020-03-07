package com.sightcorner.www.algocasts;

/**
 * Created by Aaron Zheng<br>
 * Created at 7/3/2020<br>
 * Purpose <br>
 * fucheng.zheng@gmail.com<br>
 * <p>
 * Hisotry
 * <p>
 * 1.0 7/3/2020
 */
public class Algo20 {

    /**
     * 这个题目说的是，给你两个排好序的整数数组 nums1 和 nums2，假设数组是以递增排序的，数组的大小分别是 m 和 n。
     * 你要找到这两个数组的中位数。要求算法的时间复杂度是 O(log(m+n))。
     * 这里两个数组中位数的意思是，两个数组合到一起排序后，位于中间的那个数，如果一共有偶数个，则是位于中间的两个数的平均数。
     * @param args
     */
    public static void main(String[] args) {

        int[] a1 = new int[]{1,2,6,7,8};
        int[] a2 = new int[]{3,4,5,7,9};

        System.out.println(getMin(a1, a2));

    }

    private static double getMin(int[] a1, int[] a2) {
        int l1 = a1.length;
        int l2 = a2.length;
        if(((l1+l2) & 1) == 1) {
            //奇数
            return getKthMinInTwoArray(a1, a2, (l1+l2)/2+1);
        } else {
            //偶数
            return (getKthMinInTwoArray(a1, a2, (l1+l2)/2) + getKthMinInTwoArray(a1, a2, (l1+l2)/2+1))/2;
        }
    }

    private static double getKthMinInTwoArray(int[] a1, int[] a2, int k) {
        int l1 = a1.length;
        int l2 = a2.length;
        int base1 = 0;
        int base2 = 0;

        while(true) {
            if(l1 == 0) {
                return a2[base2 + k - 1];
            }
            if(l2 == 0) {
                return a1[base1 + k - 1];
            }
            if (k == 1) {
                return Math.min(a1[base1], a2[base2]);
            }

            int i = Math.min(l1, k/2);
            int j = Math.min(l2, (k-i));

            int v1 = a1[base1 + i - 1];
            int v2 = a2[base2 + j - 1];
            if(i + j == k && v1 == v2) {
                return v1;
            }

            if(v1 >= v2) {
                base2 += j;
                l2 -= j;
                k -= j;
            }
            if(v1 <= v2) {
                base1 += i;
                l1 -= i;
                k -= i;
            }
        }
    }
}
