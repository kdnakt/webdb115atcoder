package com.kdnakt.webdb115;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream in = App.class.getClassLoader().getResourceAsStream("input");
        Scanner cin = new Scanner(in);
        long start = System.currentTimeMillis();
        int N = cin.nextInt();
        for (int i = 0; i < N; i++) {
            int A = cin.nextInt();
            long ans = 0;
            for (int j = 1; j <= A; j++) {
                ans += j;
            }
            System.out.println(ans);
        }
        System.out.println(System.currentTimeMillis() - start + " ms");
        cin.close();
    }
}
