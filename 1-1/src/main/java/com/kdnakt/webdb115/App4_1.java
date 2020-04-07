package com.kdnakt.webdb115;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class App4_1 {

    public static void main(String[] args) throws FileNotFoundException {
        try (
            InputStream in = App4_1.class.getClassLoader().getResourceAsStream("input4_1");
            Scanner cin = new Scanner(in);
        ) {
            long start = System.currentTimeMillis();
            int N = cin.nextInt();
            int K = cin.nextInt();
            int ans = 1;
            for (int i = 0; i < N; i++) {
                ans = Math.min(ans * 2, ans + K);
            }
            System.out.println(ans);
            System.out.println(System.currentTimeMillis() - start + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
