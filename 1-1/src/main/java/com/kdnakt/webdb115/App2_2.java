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
        int[] B = new int[N + 1];
        for (int i = 0; i < N; i++) B[A[i]]++;
        int Same = -1, No = -1;
        for (int i = 1; i <= N; i++) {
            if (B[i] == 0) No = i;
            if (B[i] == 2) Same = i;
        }
        if (Same == -1) System.out.println("CORRECT");
        else System.out.println(Same + " " + No);
        System.out.println(System.currentTimeMillis() - start + " ms");
        cin.close();
    }

}
