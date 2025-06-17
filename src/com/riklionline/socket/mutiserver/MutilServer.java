package com.riklionline.socket.mutiserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多客户端接入服务
 */

public class MutilServer {

    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(3);

        try {
            ServerSocket server = new ServerSocket(6666);
            System.out.println("Server started, listening on port 6666");
            while (true) {

                Socket s = server.accept();
                System.out.println(s.getInetAddress().getHostAddress());

                es.execute(new UserThread(s));

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

class UserThread implements Runnable {
    private Socket socket;

    public UserThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));

            String info = br.readLine();
            System.out.println(info);

            ps.println("echo: " + info);
            ps.flush();

            ps.close();
            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}

