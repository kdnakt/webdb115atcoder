package com.kdnakt.webdb115;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class App5_3 {

    static int N, M, Q;
    static int[] L, R, p, q;
    static int[][] table;
    static int[][] dp;

    public static void main(String[] args) throws FileNotFoundException {
        try (
            InputStream in = App5_3.class.getClassLoader().getResourceAsStream("input5_3");
            Scanner cin = new Scanner(in);
        ) {
            long start = System.currentTimeMillis();
            N = cin.nextInt();
            M = cin.nextInt();
            Q = cin.nextInt();
            L = new int[M];
            R = new int[M];
            for (int i = 0; i < M; i++) {
                L[i] = cin.nextInt();
                R[i] = cin.nextInt();
            }
            p = new int[Q];
            q = new int[Q];
            for (int i = 0; i < Q; i++) {
                p[i] = cin.nextInt();
                q[i] = cin.nextInt();
            }
            dp = new int[N+1][N+1];
            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= N; j++) {
                    dp[i][j] = -1;
                }
            }
            table = new int[N+1][N+1];
            for (int i = 0; i < M; i++) {
                table[L[i]][R[i]]++;
            }
            for (int i = 0; i < Q; i++) {
                System.out.println(query(p[i], q[i]));
            }
            System.out.println(System.currentTimeMillis() - start + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int query(int i, int j) {
        return subquery(j, j)
                - subquery(j, i - 1)
                - subquery(i - 1, j)
                + subquery(i - 1, i - 1);
    }

    private static int subquery(int i, int j) {
        if (i == 0 || j == 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int ans = subquery(i - 1, j)
                + subquery(i, j - 1)
                - subquery(i - 1, j - 1)
                + table[i][j];
        return dp[i][j] = ans;
    }

}
