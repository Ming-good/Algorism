package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2457 {

    public static void main(String[] args) throws IOException {
       BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());

       int flowers[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] token = br.readLine().split(" ");
            int start = Integer.parseInt(token[0]) * 100 + Integer.parseInt(token[1]);
            int end = Integer.parseInt(token[2]) * 100 + Integer.parseInt(token[3]);
            flowers[i][0] = start;
            flowers[i][1] = end;
        }

        Arrays.sort(flowers, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int end = 301; // 시작 날짜
        int idx = 0;
        int max = 0;
        int count = 0;

        while (end <= 1130) {
            boolean found = false;
            while (idx < n && flowers[idx][0] <= end) {
                max = Math.max(max, flowers[idx][1]);
                found = true;
                idx++;
            }

            if (!found) {
                System.out.println(0);
                return;
            }

            end = max;
            count++;
        }

        System.out.println(count);
    }
}
