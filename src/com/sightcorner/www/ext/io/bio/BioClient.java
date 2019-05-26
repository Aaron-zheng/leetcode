package com.sightcorner.www.ext.io.bio;

import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
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
public class BioClient {

    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 8080);
        //outputstream 阻塞
        OutputStream outputStream = socket.getOutputStream();

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        outputStream.write(line.getBytes(Charset.forName("UTF-8")));
        scanner.close();
        socket.close();
    }
}
