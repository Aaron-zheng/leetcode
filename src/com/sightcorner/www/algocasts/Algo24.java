package com.sightcorner.www.algocasts;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aaron Zheng<br>
 * Created at 15/3/2020<br>
 * Purpose <br>
 * fucheng.zheng@gmail.com<br>
 * <p>
 * Hisotry
 * <p>
 * 1.0 15/3/2020
 */
public class Algo24 {

    private static class Node {
        int key;
        int val;
        Node next;
        Node pre;

        public Node(int key, int val, Node next, Node pre) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.pre = pre;
        }
    }

    private static class CacheWithLRU {
        //代表最久未使用的值
        Node head = new Node(-1, -1, null, null);
        Map<Integer, Node> map = new HashMap<>();

        CacheWithLRU(int capacity) {
            for(int i = 0; i < capacity; i++) {
                Node node = new Node(-1, -1, null, null);
                head.next = node;
                node.pre = head;
                head = node;
            }
        }

        int get(int key) {
            Node node = map.get(key);
            if(null == node) {
                return -1;
            }
            return node.val;
        }

        void put(int key, int value) {
            if(map.containsKey(key)) {
                Node node = map.get(key);
                node.val = value;
            } else {
                //如果为开始值则去除
                if(head.val != -1) {
                    map.remove(head.key);
                }
                head.key = key;
                head.val = value;
                map.put(key, head);
                //这里是逆时针存放，我理解只要保持同一个方向，next / pre 都是可以的
                head = head.pre;
            }
        }

    }

    /**
     * LRU = least recently used
     *
     * 哈希表+双向链表
     *
     * 这个题目说的是，你要实现一个 LRU 缓存，提供 get 和 put 两个操作，并且要求两个操作的时间复杂度都是 O(1)。
     * 另外为了简单起见，在这个题目中，key 和 value 都是整数值，并且 value 只为正整数。
     * 因此在 get 操作中，当 key 不存在时，返回 -1 即可。
     *
     * @param args
     */
    public static void main(String[] args) {

        /**
         * TODO 未完成
         *
         */
        CacheWithLRU cacheWithLRU = new CacheWithLRU(2);
        cacheWithLRU.put(1, 1);
        cacheWithLRU.put(2, 2);
        cacheWithLRU.put(3, 3);
        //-1
        System.out.println(cacheWithLRU.get(1));
        //2
        System.out.println(cacheWithLRU.get(2));
        //3
        System.out.println(cacheWithLRU.get(3));
        cacheWithLRU.put(4, 4);
        //-1
        System.out.println(cacheWithLRU.get(2));
        //3
        System.out.println(cacheWithLRU.get(3));
        //4
        System.out.println(cacheWithLRU.get(4));
    }
}
