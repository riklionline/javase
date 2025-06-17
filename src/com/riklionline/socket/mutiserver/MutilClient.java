package com.riklionline.socket.mutiserver;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MutilClient {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入……");

        try {
            Socket socket = new Socket("127.0.0.1", 6666);

            PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String info = sc.nextLine();//此处阻塞，等待用户键盘输入

            ps.println(info);
            ps.flush();

            info = br.readLine();
            System.out.println(info);

            ps.close();
            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
