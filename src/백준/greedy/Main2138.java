package 백준.greedy;

import java.io.*;
import java.util.Arrays;

public class Main2138 {
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] from = br.readLine().toCharArray();
        char[] to = br.readLine().toCharArray();

        char[] clone = from.clone();
        clone[0] = (char) ('1'- clone[0]+'0');
        clone[1] = (char) ('1'- clone[1]+'0');
        processFlip(n, clone, to, 1);
        processFlip(n, from, to, 0);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(min);

    }

    private static void processFlip(int n, char[] from, char[] to, int flipCnt) {
        for(int i=1;i< n;i++) {
            if (from[i - 1] != to[i - 1]) {
                flipCnt++;
                flip(from, i);
            }
        }
        if (Arrays.equals(from, to)) {
            min = Math.min(min, flipCnt);
        }
    }

    private static void flip(char[] arr, int num) {
        for (int i = -1; i < 2 && i+num < arr.length; i++) {
            arr[i + num] = (char) ('1' - arr[i + num] + '0');
        }
    }

}
