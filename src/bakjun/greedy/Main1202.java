package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main1202 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nkTok = br.readLine().split(" ");
        int n = Integer.parseInt(nkTok[0]);
        int k = Integer.parseInt(nkTok[1]);
        int[][] jewels = new int[n][2];
        int[] bags = new int[k];

        for (int i =0;i<n;i++) {
            String[] j = br.readLine().split(" ");
            jewels[i][0] = Integer.parseInt(j[0]);
            jewels[i][1] = Integer.parseInt(j[1]);
        }

        for(int i=0;i<k;i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels, (a,b) -> {
            if(a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        Arrays.sort(bags);

        long sum=0;
        int idx=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i=0;i<k;i++) {
            while(idx<n &&bags[i] >= jewels[idx][0] ) {
                pq.add(jewels[idx][1]);
                idx++;
            }
            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }

        System.out.println(sum);
    }
}
