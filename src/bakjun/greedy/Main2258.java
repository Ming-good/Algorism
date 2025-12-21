package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2258 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmTokken = br.readLine().split(" ");

        int n = Integer.parseInt(nmTokken[0]);
        int m = Integer.parseInt(nmTokken[1]);

        int[][] meats = new int[n][2];

        for (int i=0;i<n;i++) {
            String[] tokken = br.readLine().split(" ");

            meats[i][0] = Integer.parseInt(tokken[0]);
            meats[i][1] = Integer.parseInt(tokken[1]);
        }

        Arrays.sort(meats, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o2[0],o1[0]);
            }
            return Integer.compare(o1[1],o2[1]);
        });

        long weight = 0;
        long currentPrice = 0;
        boolean flag = false;
        long minTotalPrice = Integer.MAX_VALUE;
        for (int i=0;i<n;i++) {

            if (i>0 && meats[i][1] == meats[i-1][1]) {
                currentPrice += meats[i][1];
            } else {
                currentPrice = meats[i][1];
            }

            weight += meats[i][0];

            if (weight >= m) {
                flag = true;
                minTotalPrice = Math.min(minTotalPrice, currentPrice);
            }
        }

        if (!flag) {
            System.out.println(-1);
            return;
        }

        System.out.println(minTotalPrice);
    }
}
