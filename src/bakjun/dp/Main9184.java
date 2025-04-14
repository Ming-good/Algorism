package bakjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9184 {

    static int[][][] w = new int[51][51][51];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder brStr = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {

            if (line.equals("-1 -1 -1")) {
                break;
            }

            String[] arr = line.split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int c = Integer.parseInt(arr[2]);
            brStr.append(String.format("w(%d, %d, %d) = ", a, b, c));
            a= a<0?0:a;
            b= b<0?0:b;
            c= c<0?0:c;
            brStr.append(w(a, b, c)).append("\n");
        }

        System.out.println(brStr);
    }

    private static int w(int a, int b, int c) {

        if (a <= 0 || b <= 0 || c <= 0) {
            return w[a][b][c] = 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        if (w[a][b][c] != 0) {
            return w[a][b][c];
        }

        if (a < b && b < c) {
            return w[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }
        return w[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
}
