package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1082 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] chTokken = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        int[] costs = new int[n];
        int[] results = new int[51];

        int minIdx = 0;
        int minNonZeroIdx = 1;

        for (int i=0;i<n;i++) {
            costs[i] = Integer.parseInt(chTokken[i]);
            if (costs[minIdx] > costs[i]) {
                minIdx = i;
            }

            if (costs[minNonZeroIdx] > costs[i] && i != 0) {
                minNonZeroIdx = i;
            }
        }

        if (m >= costs[minNonZeroIdx]) {
            results[0] = minNonZeroIdx;
            m = m- costs[minNonZeroIdx];
        }

        if (results[0] == 0) {
            System.out.println(0);
            return;
        }

        int endPoint = 0;
        for (int i=1;m>=costs[minIdx];i++) {
            results[i] = minIdx;
            m = m - costs[minIdx];
            endPoint = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<=endPoint;i++) {
             int biggerIdx = results[i];
             int freeCost = m + costs[biggerIdx];
             for (int j=n-1;j>biggerIdx;j--) {
                 if (freeCost >= costs[j]) {
                     m = freeCost - costs[j];
                     results[i] = j;
                     break;
                 }
             }
            sb.append(results[i]);
        }

        System.out.println(sb);
    }
}
