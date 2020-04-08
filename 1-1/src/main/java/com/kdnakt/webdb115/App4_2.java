package com.kdnakt.webdb115;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class App4_2 {

    public static void main(String[] args) throws FileNotFoundException {
        try (
            InputStream in = App4_2.class.getClassLoader().getResourceAsStream("input4_2");
            Scanner cin = new Scanner(in);
        ) {
            long start = System.currentTimeMillis();
            int N = cin.nextInt();
            int[] A = new int[N];
            int[] B = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = cin.nextInt();
                B[i] = cin.nextInt();
            }
            boolean[] used = new boolean[N];
            if (dfs(0, N, A, B, used, 0)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            System.out.println(System.currentTimeMillis() - start + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static boolean dfs(int depth, int N, int[] A,
            int[] B, boolean[] used, int time) {
        if (depth == N) return true;
        for (int i = 0; i < N; i++) {
            if (used[i]) continue;
            int nextTime = time + A[i];
            if (nextTime > B[i]) return false;
            used[i] = true;
            if (dfs(depth+1, N, A, B, used, nextTime)) {
                return true;
            }
            used[i] = false;
        }
        return false;
    }
}
