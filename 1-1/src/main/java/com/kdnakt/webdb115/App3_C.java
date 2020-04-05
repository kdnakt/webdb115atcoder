package com.kdnakt.webdb115;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class App3_C {
    private static class Position {
        int i, j;
        Position(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    static int N = 19;
    static char[][] B = new char[N][N];
    static int BLACK_COUNT = 0;
    static Position[] BLACK_POS = new Position[N*N];
    static int WHITE_COUNT = 0;
    static Position[] WHITE_POS = new Position[N*N];

    public static void main(String[] args) throws FileNotFoundException {
        try (
            InputStream in = App3_C.class.getClassLoader().getResourceAsStream("input3_C");
            Scanner cin = new Scanner(in);
        ) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < N; i++) {
                B[i] = cin.nextLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    char b = B[i][j];
                    if ('o' == b) {
                        BLACK_POS[BLACK_COUNT] = new Position(i, j);
                        BLACK_COUNT++;
                    } else if ('x' == b) {
                        WHITE_POS[WHITE_COUNT] = new Position(i, j);
                        WHITE_COUNT++;
                    } else {

                    }
                }
            }
            if (BLACK_COUNT == WHITE_COUNT
                    || BLACK_COUNT == WHITE_COUNT+1) {
                if (BLACK_COUNT <= 4 && WHITE_COUNT <= 4) {
                    System.out.println("YES");
                    return;
                }

                boolean isWhiteWin = checkEast(WHITE_POS[0], WHITE_POS, WHITE_COUNT, 1)
                        || checkSouth(WHITE_POS[0], WHITE_POS, WHITE_COUNT, 1)
                        || checkSouthEast(WHITE_POS[0], WHITE_POS, WHITE_COUNT, 1)
                        || checkNorthEast(WHITE_POS[0], WHITE_POS, WHITE_COUNT, 1);
                boolean isBlackWin = checkEast(BLACK_POS[0], BLACK_POS, BLACK_COUNT, 1)
                        || checkSouth(BLACK_POS[0], BLACK_POS, BLACK_COUNT, 1)
                        || checkSouthEast(BLACK_POS[0], BLACK_POS, BLACK_COUNT, 1)
                        || checkNorthEast(BLACK_POS[0], BLACK_POS, BLACK_COUNT, 1);
                if (isWhiteWin && isBlackWin) {
                    System.out.println("NO");
                    return;
                }
                if (isBlackWin && BLACK_COUNT <= WHITE_COUNT) {
                    System.out.println("NO");
                    return;
                }
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            System.out.println(System.currentTimeMillis() - start + " ms");
        } catch (IllegalStateException e) {
            System.out.println("NO");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkEast(Position pos, Position[] positions, int len, int count) {
        if (count == 10) throw new IllegalStateException();;
        for (int i = 0; i < len; i++) {
            if (pos.i == positions[i].i
                    && pos.j+1 == positions[i].j) {
                return checkEast(positions[i], positions, len, count + 1);
            }
        }
        return count >= 5;
    }

    private static boolean checkSouth(Position pos, Position[] positions, int len, int count) {
        if (count == 10) throw new IllegalStateException();
        for (int i = 0; i < len; i++) {
            if (pos.i+1 == positions[i].i
                    && pos.j == positions[i].j) {
                return checkSouth(positions[i], positions, len, count + 1);
            }
        }
        return count >= 5;
    }

    private static boolean checkSouthEast(Position pos, Position[] positions, int len, int count) {
        if (count == 10) throw new IllegalStateException();
        for (int i = 0; i < len; i++) {
            if (pos.i+1 == positions[i].i
                    && pos.j+1 == positions[i].j) {
                return checkSouthEast(positions[i], positions, len, count + 1);
            }
        }
        return count >= 5;
    }

    private static boolean checkNorthEast(Position pos, Position[] positions, int len, int count) {
        if (count == 10) throw new IllegalStateException();
        for (int i = 0; i < len; i++) {
            if (pos.i-1 == positions[i].i
                    && pos.j-1 == positions[i].j) {
                return checkNorthEast(positions[i], positions, len, count + 1);
            }
        }
        return count >= 5;
    }

}
