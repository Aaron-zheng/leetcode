package com.sightcorner.www.algocasts;

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
public class Algo17 {

    /**
     * 这个题目说的是，你要实现一个栈，除了提供 push，pop，top 等常用函数，还需要提供一个函数在 O(1) 时间内取得这个栈里的最小元素。
     * @param args
     */
    public static void main(String[] args) {
        StackWithMin stackWithMin = new StackWithMin1();
        stackWithMin.push(5);
        System.out.println("top:"+stackWithMin.top()+" min:"+stackWithMin.getMin());
        stackWithMin.push(6);
        System.out.println("top:"+stackWithMin.top()+" min:"+stackWithMin.getMin());
        stackWithMin.push(1);
        System.out.println("top:"+stackWithMin.top()+" min:"+stackWithMin.getMin());
        System.out.println("pop:"+stackWithMin.pop());
        System.out.println("top:"+stackWithMin.top()+" min:"+stackWithMin.getMin());
        //
        System.out.println();
        //
        stackWithMin = new StackWithMin2();
        stackWithMin.push(5);
        System.out.println("top:"+stackWithMin.top()+" min:"+stackWithMin.getMin());
        stackWithMin.push(6);
        System.out.println("top:"+stackWithMin.top()+" min:"+stackWithMin.getMin());
        stackWithMin.push(1);
        System.out.println("top:"+stackWithMin.top()+" min:"+stackWithMin.getMin());
        System.out.println("pop:"+stackWithMin.pop());
        System.out.println("top:"+stackWithMin.top()+" min:"+stackWithMin.getMin());

    }

    private static abstract class StackWithMin {
        abstract void push(int x);
        abstract int pop();
        abstract int top();
        abstract int getMin();

    }

    private static class StackWithMin1 extends StackWithMin {

        Stack<Integer> data = new Stack<>();
        Stack<Integer> min = new Stack<>();

        @Override
        void push(int x) {
            data.add(x);
            if(min.size() <= 0 || x <= min.peek()) {
                min.add(x);
            }
        }

        @Override
        int pop() {
            if(min.size() > 0 && data.peek() == min.peek()) {
                min.pop();
            }
            return data.pop();
        }

        @Override
        int top() {
            return data.peek();
        }

        @Override
        int getMin() {
            return min.peek();
        }
    }

    private static class StackWithMin2 extends StackWithMin {

        private Node head;
        private int min = Integer.MAX_VALUE;

        private static class Node {
            int val;
            Node next;

            public Node(int val, Node next) {
                this.val = val;
                this.next = next;
            }
        }

        @Override
        void push(int x) {
            if(x < min) {
                head = new Node(min, head);
                min = x;
            }
            head = new Node(x, head);
        }

        @Override
        int pop() {
            int val = head.val;
            if(head.val == min) {
                min = head.next.val;
                head = head.next.next;
            } else {
                head = head.next;
            }
            return val;
        }

        @Override
        int top() {
            return head.val;
        }

        @Override
        int getMin() {
            return min;
        }
    }
}
