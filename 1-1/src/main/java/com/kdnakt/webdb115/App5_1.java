package com.kdnakt.webdb115;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class App5_1 {

    static int N;
    static int[] H;
    static int[] dp;
    public static void main(String[] args) throws FileNotFoundException {
        try (
            InputStream in = App5_1.class.getClassLoader().getResourceAsStream("input5_1");
            Scanner cin = new Scanner(in);
        ) {
            long start = System.currentTimeMillis();
            N = cin.nextInt();
            H = new int[N+1];
            dp = new int[N];
            for (int i = 0; i < N; i++) {
                H[i] = cin.nextInt();
                dp[i] = -1;
            }
            System.out.println(dfs(0));
            System.out.println(System.currentTimeMillis() - start + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int dfs(int pos) {
        if (pos >= N) return 99999999;
        if (pos == N-1) return 0;
        if (dp[pos] != -1) return dp[pos];
        int step1 = dfs(pos+1) + Math.abs(H[pos+1] - H[pos]);
        int step2 = dfs(pos+2) + Math.abs(H[pos+2] - H[pos]);
        return dp[pos] = Math.min(step1, step2);
    }
}
