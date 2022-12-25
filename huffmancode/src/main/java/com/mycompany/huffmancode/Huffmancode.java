package com.mycompany.huffmancode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Huffmancode {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter word:");
        String word = sc.nextLine();

        String[] mass = word.split(" ");
        String result = "";
        for (int i = 0; i < mass.length; i++) {
            String elem = mass[i];
            if (!elem.isEmpty()) {
                result += elem;
            }
        }
        result = result.toLowerCase();
        

        ArrayList<Integer> myNumbers = new ArrayList<>();

        int count;
        char ch;
        for (ch = 'a'; ch <= 'z'; ch++) {
            count = 0;
            for (int i = 0; i < result.length(); i++) {
                char ch1 = result.charAt(i);
                if (ch == ch1) {
                    count += 1;
                }
            }
            if (count > 0) {
                System.out.println(ch + "\t\t" + count);
                myNumbers.add(count);
            }
        }
        Collections.sort(myNumbers);
        System.out.println(myNumbers);
        int size = myNumbers.size() - 1;//4

        int hasil = size * myNumbers.get(0);//4

        while (size > 0) {
            for (int i = 1; i < myNumbers.size(); i++) {//4
                int index = 0;
                index = myNumbers.get(i);//2
                index *= size;//2
                hasil += index;//15
                size--;//0
            }
        }
        int sum = 0;
        for (int i = 0; i < myNumbers.size(); i++) {
            sum += myNumbers.get(i);
        }

        int end = myNumbers.size() * 8 + sum + hasil;

        System.out.println("before process: " + result.length() * 8 + " bit");

        System.out.println("after process: " + end + " bit");

        int result_bitsize = result.length() * 8;

        if (end > result_bitsize) {
            System.out.println("we are at a loss");
            int percent = (100 * end) / result_bitsize;
            percent -= 100;
            System.out.println("It increased by " + percent + " percent");
        } else if (end == result_bitsize) {
            System.out.println("same");
        } else {
            System.out.println("successful compression");
            int percent = (end * 100) / result_bitsize;
            percent = 100 - percent;
            System.out.println("It decreased by " + percent + " percent");
        }

    }

}
