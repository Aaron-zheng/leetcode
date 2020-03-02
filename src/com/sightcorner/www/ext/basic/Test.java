package com.sightcorner.www.ext.basic;

import java.util.Stack;

/**
 * Created by Aaron Zheng<br>
 * Created at 2/3/2020<br>
 * Purpose <br>
 * fucheng.zheng@gmail.com<br>
 * <p>
 * Hisotry
 * <p>
 * 1.0 2/3/2020
 */
public class Test {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}
