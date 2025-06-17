package com.riklionline.socket.echo;

import java.io.*;
import java.net.Socket;

public class EchoClient {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1", 6666);

            PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            ps.println("Client-Rikli: Hello Server!");
            ps.flush();

            String info = br.readLine();
            System.out.println(info);

            ps.close();
            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
