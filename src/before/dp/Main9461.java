package before.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main9461 {
    static long[] P = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        P[0] = 0;
        P[1] = 1;
        P[2] = 1;

        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < length; i++) {
            int n = Integer.parseInt(br.readLine());
            max = Math.max(n, max);
            list.add(n);
        }
        triangle(3, max);

        for (Integer n : list) {
            System.out.println(P[n]);
        }
    }

    private static void triangle(int start, int end){
        for (int i = start; i <= end; i++) {
            P[i] = P[i - 2] + P[i - 3];
        }
    }
}
