package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2109 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dp[i][0] = Integer.parseInt(st.nextToken());
            dp[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(dp, (a,b) -> {
            if (a[1] == b[1]) return Integer.compare(b[0], a[0]);
            return Integer.compare(a[1], b[1]);
        });


        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int cur = dp[i][1];
            for (int j = i; j<n&&cur==dp[j][1]; i=j++) {
                pq.add(dp[j][0]);
                if (pq.size() > cur || pq.size() > n) {
                    pq.poll();
                }
            }
        }
        Integer sum = pq.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
    }
}
