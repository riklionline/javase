package com.riklionline.list.threadsafe;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Solution solution = new Solution();

        //得到一个线程安全的list集合对象
        List<Integer> list = solution.getList();

        Thread[] thread = new Thread[10];
        for (int j = 0; j < 10; j++) {
            thread[j] = new Thread(() -> {
                try {
                    for (int i = 0; i < n; i++) {
                        list.add(i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        for (Thread t : thread) {
            t.start();
        }
        Thread.sleep(10);
        System.out.println(list.size());

        sc.close();
    }
}