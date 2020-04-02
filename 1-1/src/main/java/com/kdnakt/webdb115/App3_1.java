package com.kdnakt.webdb115;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class App3_1 {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream in = App3_1.class.getClassLoader().getResourceAsStream("input3_1");
        Scanner cin = new Scanner(in);
        long start = System.currentTimeMillis();
        int N = cin.nextInt();
        if (N < 10) {
            System.out.println("Yes");
            return;
        }
        for (int i = 2; i < 10; i++) {
            if (N % i == 0) {
                int rem = N / i;
                if (rem < 10) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
        System.out.println(System.currentTimeMillis() - start + " ms");
        cin.close();
    }

}
