package com.kdnakt.webdb115;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class App2_2 {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream in = App2_2.class.getClassLoader().getResourceAsStream("input2_2");
        Scanner cin = new Scanner(in);
        long start = System.currentTimeMillis();
        int N = cin.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = cin.nextInt();
        int Same = checkSame(N, A);
        int No = checkNo(N, A);
        if (Same == -1) System.out.println("CORRECT");
        else System.out.println(Same + " " + No);
        System.out.println(System.currentTimeMillis() - start + " ms");
        cin.close();
    }

    static int checkSame(int N, int[] A) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] == A[j]) return A[i];
            }
        }
        return -1;
    }

    static int checkNo(int N, int[] A) {
        for (int i = 1; i <= N; i++) {
            boolean exist = false;
            for (int j = 0; j < N; j++) {
                if (A[j] == i) {
                    exist = true;
                    break;
                }
            }
            if (!exist) return i;
        }
        return -1;
    }

}
