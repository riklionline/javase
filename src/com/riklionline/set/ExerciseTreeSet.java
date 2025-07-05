package com.riklionline.set;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class ExerciseTreeSet {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the character: ");
        String line = scanner.nextLine();
        char[] charArray = line.toCharArray();
        System.out.println("CharArray: " + Arrays.toString(charArray));

        TreeSet<Character> ts = new TreeSet<>(new Comparator<Character>() {

            @Override
            public int compare(Character o1, Character o2) {
                System.out.println("compare is executing: " + o1 + " and " + o2  );
                int num = o1.compareTo(o2);
                return num == 0 ? 1 : num;
            }
        });

        for (char c : charArray) {
            ts.add(c);
        }

        for (Character t : ts) {
            System.out.print(t);
        }
    }

}
