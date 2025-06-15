package com.riklionline.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8888);

        System.out.println("Server started");

        Socket accept = serverSocket.accept();

        System.out.println("Accepted connection from " + accept);

        byte[] bytes = new byte[1024];
        int len = accept.getInputStream().read(bytes);

        System.out.println(new String(bytes, 0, len));

        accept.getOutputStream().write("Server: Received, thanks".getBytes());

        //用于刷新输出流，确保所有缓冲的输出字节被写出
        accept.getOutputStream().flush();

        accept.close();
        serverSocket.close();

    }

}
