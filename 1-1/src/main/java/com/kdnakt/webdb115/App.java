package com.kdnakt.webdb115;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream in = App.class.getClassLoader().getResourceAsStream("input");
        Scanner cin = new Scanner(in);
        int N = cin.nextInt();
        for (int i = 0; i < N; i++) {
            int A = cin.nextInt();
            long ans = 0;
            for (int j = 0; j < A; j++) {
                ans += j;
            }
            System.out.println(ans);
        }
        cin.close();
    }
}
