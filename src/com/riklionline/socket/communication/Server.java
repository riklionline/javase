package com.riklionline.socket.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程之间的通信，可以将线程（Object）放入一个集合中管理，通过遍历集合元素获取信息
 * Socket.accept() ——> socket.getIOStream ——> IOStream(info)
 */

public class Server {

    public static void main(String[] args) {

        //保存处理客户端的线程
        Vector<UserThread> vector = new Vector<>();
        ExecutorService es = Executors.newFixedThreadPool(5);

        try {
            ServerSocket server = new ServerSocket(6666);
            System.out.println("Server started, listening on port 6666.");

            while (true) {
                //主线程，此处等待Client时会造成阻塞（大堂经理接收传递客户消息）
                Socket socket = server.accept();
                //每次有client进来才会触发new UserThread，并且把它的socket放进一个新的线程里
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
    private boolean flag = true;


    public UserThread(Socket socket, Vector<UserThread> vector) {
        this.socket = socket;
        this.vector = vector;
        vector.add(this);//vector中存放的是UserThread对象
    }

    @Override
    public void run() {

        try {
            System.out.println("客户端" + socket.getInetAddress().getHostAddress() + "已连接；");
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());

            while (flag) {
                //循环读取消息对象，等待Client的oos时，这里会造成阻塞
                Message msg = (Message) ois.readObject();
                switch (msg.getType()) {
                    case MessageType.TYPE_LOGIN:
                        name = msg.getFrom();
                        msg.setInfo("欢迎您：");
                        oos.writeObject(msg);
                        break;
                    case MessageType.TYPE_SENT:
                        String to = msg.getTo();
                        UserThread ut;
                        int size = vector.size();
                        for (int i = 0; i < size; i++) {
                            ut = vector.get(i);
                            if (to.equals(ut.name) && ut != this) {
                                ut.oos.writeObject(msg);
                                break;
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