package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1826_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken());
        int curStat = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int stopCnt = 0;
        int idx = 0;
        while(curStat < target) {
            while(idx<n && arr[idx][0]<=curStat) {
                pq.add(arr[idx++][1]);
            }

            if (pq.isEmpty()) {
                System.out.println(-1);
                return;
            }

            curStat += pq.poll();
            stopCnt++;
        }

        System.out.println(stopCnt);
    }
}
