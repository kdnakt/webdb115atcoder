package com.kdnakt.webdb115;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class App5_1 {

    static int N;
    static int[] H;
    public static void main(String[] args) throws FileNotFoundException {
        try (
            InputStream in = App5_1.class.getClassLoader().getResourceAsStream("input5_1");
            Scanner cin = new Scanner(in);
        ) {
            long start = System.currentTimeMillis();
            N = cin.nextInt();
            H = new int[N+1];
            for (int i = 0; i < N; i++) {
                H[i] = cin.nextInt();
            }
            int[] dp = new int[N];
            dp[0] = 0;
            dp[1] = Math.abs(H[1] - H[0]);
            for (int i = 2; i < N; i++) {
                int step1 = dp[i-1] + Math.abs(H[i] - H[i-1]);
                int step2 = dp[i-2] + Math.abs(H[i] - H[i-2]);
                dp[i] = Math.min(step1, step2);
            }
            System.out.println(dp[N-1]);
            System.out.println(System.currentTimeMillis() - start + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
