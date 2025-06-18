package com.riklionline.socket.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) {

        Vector<UserThread> vector = new Vector<>();
        ExecutorService es = Executors.newFixedThreadPool(5);

        try {
            ServerSocket server = new ServerSocket(6666);

            while (true) {
                Socket socket = server.accept();

                UserThread user = new UserThread(socket, vector);
                es.execute(user);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class UserThread implements Runnable {

    private String name;
    private Socket socket;
    Vector<UserThread> vector;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private boolean flag;


    public UserThread(Socket socket, Vector<UserThread> vector) {
        this.socket = socket;
        this.vector = vector;
        vector.add(this);//vector中存放的是UserThread对象
    }

    @Override
    public void run() {

        try {
            System.out.println("客户端" + socket.getInetAddress().getHostAddress() + "已连接；");
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            while (flag) {

                Message msg = (Message) ois.readObject();
                switch (msg.getType()) {
                    case MessageType.TYPE_LOGIN:
                        name = msg.getFrom();
                        System.out.println("欢迎您：" + name);
                        oos.writeObject(msg);
                        break;
                    case MessageType.TYPE_SENT:
                        String to = msg.getTo();
                        UserThread ut;
                        int size = vector.size();
                        for (int i = 0; i < size; i++) {
                            ut = vector.get(i);
                            if (to.equals(ut.name) && ut != this) { //????
                                ut.oos.writeObject(msg); // ????
                            }
                        }

                        break;
                }

            }
            ois.close();
            oos.close();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}