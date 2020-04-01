package com.kdnakt.webdb115;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class App2_1 {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream in = App2_1.class.getClassLoader().getResourceAsStream("input2_1");
        Scanner cin = new Scanner(in);
        long start = System.currentTimeMillis();
        int A = cin.nextInt(), B = cin.nextInt();
        int ans = B / A;
        if (B % A != 0) ans++;
        System.out.println(ans);
        System.out.println(System.currentTimeMillis() - start + " ms");
        cin.close();
    }
}
