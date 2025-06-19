package com.riklionline.socket.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExecutorService es = Executors.newSingleThreadExecutor();

        try {
            Socket socket = new Socket("localhost", 6666);
            System.out.println("服务器连接成功。");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            //向服务器发送登录信息
            System.out.println("请输入名称：");
            String name = sc.nextLine();
            Message msg = new Message(name, null, MessageType.TYPE_LOGIN, null);
            oos.writeObject(msg);

            //理论上当从网络流读取对象时，数据尚未到达之前，ois都会造成网络I/O阻塞
            msg = (Message) ois.readObject();
            System.out.println(msg.getInfo() + msg.getFrom());

            //启动读取消息线程
            es.execute(new ReadInfoThread(ois));

            //使用主线程循环发送消息
            boolean flag = true;
            while (flag) {
                msg = new Message();
                System.out.println("To:");
                msg.setTo(sc.nextLine());
                msg.setFrom(name);
                msg.setType(MessageType.TYPE_SENT);
                System.out.println("Info:");
                msg.setInfo(sc.nextLine());

                oos.writeObject(msg);

            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class ReadInfoThread implements Runnable {
    private ObjectInputStream ois;
    private boolean flag = true;

    public ReadInfoThread(ObjectInputStream ois) {
        this.ois = ois;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            System.out.println("启动ReadInfoThread: " + this);
            while (flag) {

                Message message = (Message) ois.readObject();
                System.out.println("[" + message.getFrom() + "]" + "对我说：" + message.getInfo());

            }
            if (ois != null) {
                ois.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
