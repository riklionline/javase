package com.riklionline.socket;

import java.io.IOException;
import java.net.Socket;

/**
 * socket是通信设备的端点？
 */
public class TCPClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",8888);

        socket.getOutputStream().write(("Client-RikLi: Hello Server!").getBytes());

        //用于刷新输出流，确保所有缓冲的输出字节被写出
        socket.getOutputStream().flush();

        byte[] bytes = new byte[1024];

        int len = socket.getInputStream().read(bytes);

        System.out.println(new String(bytes, 0, len));

        socket.close();


    }

}
