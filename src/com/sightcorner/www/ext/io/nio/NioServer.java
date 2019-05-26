package com.sightcorner.www.ext.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
public class NioServer {


    public static void main(String[] args) throws Exception{
        new NioServer().selectorChannel();
    }



    private void selectorChannel() throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        SelectionKey selectionKey = serverSocketChannel
                .register(selector, 0, serverSocketChannel);
        //对accept事件订阅
        selectionKey.interestOps(SelectionKey.OP_ACCEPT);
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));

        while(true) {
            System.out.println(1);
            //阻塞，直到有事件通知
            selector.select();

            Set<SelectionKey> sets = selector.selectedKeys();
            Iterator<SelectionKey> iterator = sets.iterator();
            while(iterator.hasNext()) {
                SelectionKey k = iterator.next();
                iterator.remove();


                //关注 accept 事件
                if(k.isAcceptable()) {
                    ServerSocketChannel s = (ServerSocketChannel) k.attachment();
                    SocketChannel socketChannel = s.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ, socketChannel);
                    System.out.println("connect " + socketChannel.getRemoteAddress());
                }

                //关注 read 事件
                if(k.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) k.attachment();
                    try {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        this.proceed(byteBuffer, socketChannel);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }


    }


    /**
     * 一个线程，处理多个链接
     *
     *
     * @throws Exception
     */
    private void multipleChannel() throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));

        List<SocketChannel> channels = new ArrayList<>();

        while(true) {
            SocketChannel socketChannel = serverSocketChannel.accept();

            if(null != socketChannel) {
                System.out.println("received: " + socketChannel.getRemoteAddress());
                socketChannel.configureBlocking(false);
                channels.add(socketChannel);
            } else {
                Iterator<SocketChannel> iterator = channels.iterator();
                while(iterator.hasNext()) {
                    SocketChannel sc = iterator.next();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                    if(sc.read(byteBuffer) == 0) {
                        //0代表，这个通道没有数据处理，那就可以跳过
                        continue;
                    }

                    this.proceed(byteBuffer, sc);

                }
            }
        }

    }

    /**
     * 一个线程处理一个链接
     *
     * @throws Exception
     */
    private void singleChannel() throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //所有socket默认都是blocking的
        //设置为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));

        while(true) {
            SocketChannel socketChannel = serverSocketChannel.accept();

            if(null != socketChannel) {
                System.out.println("received: " + socketChannel.getRemoteAddress());
                //设置为非阻塞
                socketChannel.configureBlocking(false);

                try {
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    this.proceed(byteBuffer, socketChannel);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     *
     *
     * @param byteBuffer
     * @param socketChannel
     * @throws Exception
     */
    private void proceed(ByteBuffer byteBuffer, SocketChannel socketChannel) throws Exception{
        //返回-1代表网络终端
        while(socketChannel.isOpen() && socketChannel.read(byteBuffer) != -1) {
            //长链接情况，需要手动判断数据读取是否结束，
            //简单判断，超过0则为结束
            if(byteBuffer.position() > 0) {
                break;
            }
        }
        //没数据，就跳过
        if(byteBuffer.position() == 0) {
            return;
        }
        //开始读数据了
        byteBuffer.flip();
        byte[] content = new byte[byteBuffer.limit()];
        byteBuffer.get(content);
        System.out.println("data: " + new String(content) + " from: " + socketChannel.getRemoteAddress());

        String response = "HTTP/1.1 200 OK Content-Length: 11 HelloWorld";
        ByteBuffer buffer = ByteBuffer.wrap(response.getBytes());
        while(buffer.hasRemaining()) {
            socketChannel.write(buffer);
        }
    }
}
