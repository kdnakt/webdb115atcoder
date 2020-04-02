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
                for (int B = 0; B <= N; B++) {
                    for (int C = 0; C <= N; C++) {
                        int num = A + B + C;
                        int money = 10000 * A + 5000 * B + 1000 * C;
                        if (num == N && money == Y) {
                            System.out.println(A + " " + B + " " + C);
                            return;
                        }
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
