package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main1398 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] f = new int[100];
        Arrays.fill(f, Integer.MAX_VALUE);
        final int[] mArr = {1, 10 ,25};
        f[0] = 0;
        for (int m : mArr) {
            for (int i = m; i < 100; i++) {
                f[i] = Math.min(f[i], f[i-m]+1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i=0;i<n;i++) {
            long price = Long.parseLong(br.readLine());
            int cnt=0;
            while(price>0) {
                long twicN = price % 100;
                cnt += f[(int) twicN];
                price = price / 100;
            }
            list.add(cnt);

        }

        list.stream().forEach(System.out::println);
    }
}
