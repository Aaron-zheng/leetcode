package com.sightcorner.www.ext.io.bio;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
public class BioServer {

    public static void main(String[] args) throws Exception {
        new BioServer().multipleServerSocket();
    }

    /**
     * 多线程的server socket
     *
     * @throws Exception
     */
    private void multipleServerSocket() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(8080);
        while(!serverSocket.isClosed()) {
            Socket socket = serverSocket.accept();
            executorService.execute(() -> {
                try {
                    this.executeSocket(socket);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }


    /**
     * 单线程的serversocket
     *
     * @throws Exception
     */
    private void singleServerSocket() throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);

        while(!serverSocket.isClosed()) {
            Socket socket = serverSocket.accept();
            this.executeSocket(socket);
        }
    }


    /**
     * 单线程处理 socket
     *
     * @param socket
     * @throws Exception
     */
    private void executeSocket(Socket socket) throws Exception {
        System.out.println("connect by: " + socket.toString());

        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream, "UTF-8"));
            String msg;
            while ((msg = bufferedReader.readLine()) != null) {
                System.out.println("received msg: " + msg);
            }
            System.out.println("request: " + socket.toString());
        } catch (Exception ex) {

        } finally {
            socket.close();
        }
    }

}
