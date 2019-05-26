package com.sightcorner.www.ext.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

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
public class NioClient {

    public static void main(String[] args) throws Exception{
        SocketChannel socketChannel = SocketChannel.open();
        //设置非阻塞
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("localhost", 8080));

        while(!socketChannel.finishConnect()) {
            //如果没链接上，则等待
            Thread.yield();
        }

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        ByteBuffer byteBuffer = ByteBuffer.wrap(line.getBytes());
        while(byteBuffer.hasRemaining()) {
            socketChannel.write(byteBuffer);
        }

        System.out.println();

        ByteBuffer serverBuffer = ByteBuffer.allocate(1024);
        while(socketChannel.isOpen() && socketChannel.read(serverBuffer) != -1) {
            if(serverBuffer.position() > 0) {
                break;
            }
        }

        //读取
        serverBuffer.flip();
        byte[] content = new byte[serverBuffer.limit()];
        serverBuffer.get(content);

        System.out.println(new String(content));
        scanner.close();
        socketChannel.close();
    }
}
