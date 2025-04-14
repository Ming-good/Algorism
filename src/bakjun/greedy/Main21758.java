package bakjun.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main21758 {
    static long[] honey;
    static long[] toRightTotal;
    static long[] toLeftTotal;
    static long max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] token  = br.readLine().split(" ");
        honey = new long[n];
        toRightTotal = new long[n];
        toLeftTotal = new long[n];
        long total = 0;
        long midMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            honey[i] = Integer.parseInt(token[i]);
            total += honey[i];
            toRightTotal[i] = total;
            if(i>0 && i<n-1) midMax = Math.max(midMax, honey[i]);
        }

        int tmp = 0;
        for (int i = n-1; i>=0; i--) {
            tmp += honey[i];
            toLeftTotal[i] = tmp;
        }

        // 1. 벌 좌측  꿀 우측
        case1(total, n);
        case2(total, n);
        case3(total, n, midMax);
        System.out.println(max);

    }

    private static void case1(long total, int n) {
        long beeA = 0;
        long beeB = 0;

        for (int i = 1; i < n-1; i++) {
            beeA = total-honey[0]-honey[i];
            beeB = total-toRightTotal[i];
            max = Math.max(max, beeA + beeB);
        }
    }
    private static void case2(long total, int n) {
        long beeA = 0;
        long beeB = 0;

        for (int i = n-2; i >= 1; i--) {
            beeA = total-honey[n-1]-honey[i];
            beeB = total-toLeftTotal[i];
            max = Math.max(max, beeA + beeB);
        }
    }

    private static void case3(long total,int n ,long midMax) {
        max = Math.max(total - honey[0] - honey[n - 1] + midMax, max);
    }
}
