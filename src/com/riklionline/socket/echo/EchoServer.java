package com.riklionline.socket.echo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) {


        try {
            ServerSocket serverSocket = new ServerSocket(6666);

            System.out.println("服务器已启动，等待客户端接入……");

            Socket socket = serverSocket.accept();

            System.out.println("客户端连接成功：" + socket.getRemoteSocketAddress());

            InputStream is = socket.getInputStream();
            System.out.println(is.getClass().getName());//java.net.SocketInputStream

            //InputStreamReader是转换流，字节流——>字符流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String info = br.readLine();
            System.out.println(info);

            PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));

            ps.println("echo:" + info);
            ps.flush();

            ps.close();
            br.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
