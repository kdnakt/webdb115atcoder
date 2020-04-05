package com.kdnakt.webdb115;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class App3_C {
    static int N = 19;
    static char[][] B = new char[N][N];
    static int BLACK_COUNT = 0;
    static int WHITE_COUNT = 0;

    public static void main(String[] args) throws FileNotFoundException {
        try (
            InputStream in = App3_C.class.getClassLoader().getResourceAsStream("input3_C");
            Scanner cin = new Scanner(in);
        ) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < N; i++) {
                B[i] = cin.nextLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    char b = B[i][j];
                    if ('○' == b) {
                        BLACK_COUNT++;
                    } else if ('×' == b) {
                        WHITE_COUNT++;
                    } else {

                    }
                }
            }
            if (BLACK_COUNT != WHITE_COUNT
                    && BLACK_COUNT != WHITE_COUNT+1) {
                System.out.println("NO");
                return;
            }
            System.out.println("YES");
            System.out.println(System.currentTimeMillis() - start + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
