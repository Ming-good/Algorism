package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1727 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokken = br.readLine().split(" ");
        int n = Integer.parseInt(tokken[0]);
        int m = Integer.parseInt(tokken[1]);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[][] dp = new int[1001][1001];
        int[] p1 = new int[n+1];
        int[] p2 = new int[m+1];
        int man = Math.min(n, m);
        for (int i = 1; i <= n || i<= m; i++) {
            if (i<=n) {
                p1[i] = Integer.parseInt(st1.nextToken());
            }

            if (i<=m) {
                p2[i] = Integer.parseInt(st2.nextToken());
            }

            if (i<=man) {
                dpInit(dp, i);
            }
        }

        Arrays.sort(p1);
        Arrays.sort(p2);

        int minCnt = n <= m ? countCuple(p1, p2, dp) : countCuple(p2, p1, dp);
        System.out.println(minCnt);
    }
    public static void dpInit(int[][] dp, int n) {
        for (int i = 0; i < n; i++) {
            dp[n][i] = Integer.MAX_VALUE;
        }
    }

    public static int countCuple(int[] m, int[] w, int[][] dp) {
        for (int i = 1; i < m.length; i++) {
            for (int j = i; j < w.length; j++) {
                dp[i][j] = Math.min(dp[i-1][j-1] + Math.abs(m[i] - w[j]), dp[i][j-1]);
            }
        }
        return dp[m.length-1][w.length-1];
    }
}
