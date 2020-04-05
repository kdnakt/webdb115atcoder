package com.kdnakt.webdb115;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class App3_3 {

    static int N;
    static int[][] A;
    public static void main(String[] args) throws FileNotFoundException {
        try (
            InputStream in = App3_3.class.getClassLoader().getResourceAsStream("input3_3");
            Scanner cin = new Scanner(in);
        ) {
            long start = System.currentTimeMillis();
            N = cin.nextInt();
            A = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    A[i][j] = A[j][i] = cin.nextInt();
                }
                
            }
            int[] Group = new int[N];
            System.out.println(dfs(0, Group));
            System.out.println(System.currentTimeMillis() - start + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int dfs(int d, int[] Group) {
        if (d == N) {
            int Point = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (Group[i] == Group[j]) {
                        Point += A[i][j];
                    }
                }
            }
            return Point;
        } else {
            int ans = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                Group[d] = i;
                ans = Math.max(ans, dfs(d + 1, Group));
            }
            return ans;
        }
    }
}
