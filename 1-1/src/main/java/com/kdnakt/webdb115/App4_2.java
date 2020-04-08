package com.kdnakt.webdb115;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
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
            Work[] W = new Work[N];
            for (int i = 0; i < N; i++) {
                A[i] = cin.nextInt();
                B[i] = cin.nextInt();
                W[i] = new Work(A[i], B[i]);
            }
            if (solve(N, W)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            System.out.println(System.currentTimeMillis() - start + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Work implements Comparable<Work> {
        public int A, B;
        public Work(int A, int B) {
            this.A = A;
            this.B = B;
        }
        @Override
        public int compareTo(Work w) {
            return this.B - w.B;
        }
    }

    static boolean solve(int N, Work[] W) {
        Arrays.sort(W);
        int time = 0;
        for (Work w: W) {
            time += w.A;
            if (time > w.B) return false;
        }
        return true;
    }
}
