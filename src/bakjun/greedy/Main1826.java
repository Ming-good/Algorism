package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1826 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] gasLo = new int[n][2];
        int endPoint = 0;
        int curGas = 0;

        for (int i=0;i<n;i++) {
            StringTokenizer tokken = new StringTokenizer(br.readLine());
            gasLo[i][0] = Integer.parseInt(tokken.nextToken());
            gasLo[i][1] = Integer.parseInt(tokken.nextToken());
        }
        StringTokenizer tokken = new StringTokenizer(br.readLine());
        endPoint = Integer.parseInt(tokken.nextToken());
        curGas = Integer.parseInt(tokken.nextToken());

        Arrays.sort(gasLo, (a, b) -> Integer.compare(a[0], b[0]));

        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i <= n; i++) {
            if(curGas >= endPoint) {
                System.out.println(i);
                return;
            }

            if(i==n) {
                break;
            }

            while(idx < n && curGas>=gasLo[idx][0]) {
                pq.add(gasLo[idx][1]);
                idx++;
            }

            if (!pq.isEmpty()) {
                Integer poll = pq.poll();
                curGas += poll;
            }
        }

        System.out.println(-1);
    }
}
