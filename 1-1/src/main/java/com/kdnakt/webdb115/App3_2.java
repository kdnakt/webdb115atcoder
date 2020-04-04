package com.kdnakt.webdb115;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class App3_2 {
    public static void main(String[] args) throws FileNotFoundException {
        try (
            InputStream in = App3_2.class.getClassLoader().getResourceAsStream("input3_2");
            Scanner cin = new Scanner(in);
        ) {
            long start = System.currentTimeMillis();
            int N = cin.nextInt();
            int Y = cin.nextInt();
            for (int A = 0; A <= N; A++) {
                for (int B = 0; A + B <= N; B++) {
                    int C = N - A - B;
                    int money = 10000 * A + 5000 * B + 1000 * C;
                    if (money == Y) {
                        System.out.println(A + " " + B + " " + C);
                        return;
                    }
                }
            }
            System.out.println("-1 -1 -1");
            System.out.println(System.currentTimeMillis() - start + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
