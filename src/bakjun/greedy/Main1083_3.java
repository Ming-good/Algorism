package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1083_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        String[] token = br.readLine().split(" ");
        Integer s = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(token[i]);
        }

        for (int i = 0; i < n&&0<s; i++) {
            int maxIdx = i;
            for (int j = i+1; j-i<=s&&j<n; j++) {
                if (arr[maxIdx] < arr[j]) {
                    maxIdx = j;
                }
            }

            if (maxIdx == i) {
                continue;
            }

            int maxVal = arr[maxIdx];
            for (int j = maxIdx; j>i; j--) {
                arr[j] = arr[j - 1];
            }
            arr[i] = maxVal;
            s = s - (maxIdx-i);
        }

        StringBuilder bs = new StringBuilder();
        for (int a : arr) {
            bs.append(a).append(" ");
        }

        System.out.println(bs.toString().trim());
    }
}
