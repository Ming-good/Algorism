package 백준.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//https://www.acmicpc.net/problem/1074
public class Main1074 {

    static int R,C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NRC = br.readLine().split(" ");

        int N = Integer.parseInt(NRC[0]);
        R = Integer.parseInt(NRC[1]);
        C = Integer.parseInt(NRC[2]);
        findLocation(N, C, R);
        System.out.println(result);

    }

    static int result = 0;
    private static void findLocation(int N, int col, int row) {
        if (N == 0) {
            return;
        }

        int size = 1<<N;
        int half = size / 2;

        if (col < half && row < half) {
            findLocation(N - 1, col, row);
        } else if (col >= half && row < half) {
            result += half * half;
            findLocation(N - 1, col-half, row);
        } else if (col < half && row >= half) {
            result += 2 * half * half;
            findLocation(N - 1, col, row-half);
        } else {
            result += 3 * half * half;
            findLocation(N - 1, col-half, row-half);
        }
    }
}
