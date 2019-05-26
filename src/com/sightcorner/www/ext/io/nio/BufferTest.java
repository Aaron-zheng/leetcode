package com.sightcorner.www.ext.io.nio;

import java.nio.ByteBuffer;

/**
 * Created by Aaron Zheng<br>
 * Created at 26/5/2019<br>
 * Purpose <br>
 * fucheng.zheng@gmail.com<br>
 * <p>
 * Hisotry
 * <p>
 * 1.0 26/5/2019
 */
public class BufferTest {

    public static void main(String[] args) {

        /**
         * 堆内存heap
         */
//        ByteBuffer byteBuffer = ByteBuffer.allocate(4);


        /**
         * 堆外内存分配，性能优化
         */
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4);

        printByteBuffer(byteBuffer);

        byteBuffer.put((byte)1);
        printByteBuffer(byteBuffer);

        byteBuffer.put((byte)2);
        printByteBuffer(byteBuffer);

        byteBuffer.put((byte)3);
        printByteBuffer(byteBuffer);

        //超过capacity插入，会报错
        //position默认是0，第一个元素插入后是1

        //必须调用flip，因为position会归0，才可以读
        byteBuffer.flip();
        printByteBuffer(byteBuffer);

        byte a = byteBuffer.get();
        System.out.println("1=" + a);
        printByteBuffer(byteBuffer);

        byte b = byteBuffer.get();
        System.out.println("2=" + b);
        printByteBuffer(byteBuffer);

        byte c = byteBuffer.get();
        System.out.println("3=" + c);
        printByteBuffer(byteBuffer);

        //超出limit读取，会报错


        //
        byteBuffer.compact();
        printByteBuffer(byteBuffer);


        byteBuffer.put((byte)4);
        printByteBuffer(byteBuffer);

        byteBuffer.put((byte)5);
        printByteBuffer(byteBuffer);

        byteBuffer.put((byte)6);
        printByteBuffer(byteBuffer);

    }

    private static void printByteBuffer(ByteBuffer byteBuffer) {
        System.out.println(String.format("capacity: %s, position: %s, limit: %s",
                byteBuffer.capacity(), byteBuffer.position(), byteBuffer.limit()));

    }
}
