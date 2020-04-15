package com.kdnakt.webdb115;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class App5_2 {

    static int N;
    static int[] A, B, C;

    public static void main(String[] args) throws FileNotFoundException {
        try (
            InputStream in = App5_2.class.getClassLoader().getResourceAsStream("input5_2");
            Scanner cin = new Scanner(in);
        ) {
            long start = System.currentTimeMillis();
            N = cin.nextInt();
            A = new int[N];
            B = new int[N];
            C = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = cin.nextInt();
                B[i] = cin.nextInt();
                C[i] = cin.nextInt();
            }

            int[][] dp = new int[N][3];
            dp[0][0] = A[0];
            dp[0][1] = B[0];
            dp[0][2] = C[0];
            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]) + A[i];
                dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + B[i];
                dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + C[i];
            }
            System.out.println(
                    Math.max(Math.max(dp[N-1][0], dp[N-1][1]),
                    dp[N-1][2]));
            System.out.println(System.currentTimeMillis() - start + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
