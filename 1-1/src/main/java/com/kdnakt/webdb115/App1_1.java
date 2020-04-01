package com.kdnakt.webdb115;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class App1_1 {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream in = App1_1.class.getClassLoader().getResourceAsStream("input1_1");
        Scanner cin = new Scanner(in);
        long start = System.currentTimeMillis();
        int N = cin.nextInt();
        for (int i = 0; i < N; i++) {
            int A = cin.nextInt();
            long ans = (long) A * (A + 1) / 2;
            System.out.println(ans);
        }
        System.out.println(System.currentTimeMillis() - start + " ms");
        cin.close();
    }
}
