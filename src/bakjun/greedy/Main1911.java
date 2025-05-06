package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1911 {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] poolInfos = br.readLine().split(" ");
        int n = Integer.parseInt(poolInfos[0]);
        int l = Integer.parseInt(poolInfos[1]);

        int[][] pool = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] poolToken = br.readLine().split(" ");
            pool[i][0] = Integer.parseInt(poolToken[0]);
            pool[i][1] = Integer.parseInt(poolToken[1]);
        }

        Arrays.sort(pool, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        int cnt=0;
        int start = pool[0][0];
        for (int i = 0; i < n; i++) {
            if (start < pool[i][0]) {
                start = pool[i][0];
            }

            int distance = pool[i][1] - start;
            int needTool = (distance + l - 1) / l;
            cnt += needTool;
            start+=l*needTool;
        }
        System.out.println(cnt);
    }
}
