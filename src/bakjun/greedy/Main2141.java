package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2141 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] arr = new long[n][2];
        long totalPeple = 0;
        for (int i = 0; i < n; i++) {
            String[] tokken = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(tokken[0]);
            arr[i][1] = Integer.parseInt(tokken[1]);
            totalPeple += arr[i][1];
        }

        Arrays.sort(arr, (a, b) -> Long.compare(a[0], b[0]));

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i][1];
            if ((totalPeple + 1) / 2 <= sum) {
                System.out.println(arr[i][0]);
                return;
            }
        }
    }
}
