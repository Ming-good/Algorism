package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1083 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] token = br.readLine().split(" ");
        int s = Integer.parseInt(br.readLine());

        int[] arrInt = new int[n];

        for (int i = 0; i < n; i++) {
            arrInt[i] = Integer.parseInt(token[i]);
        }

        for (int i = 0; i < n && s > 0; i++) {
            int maxIdx = i;
            for (int j = i+1; j < n && j - i <= s; j++) {
                if (arrInt[maxIdx] < arrInt[j]) {
                    maxIdx = j;
                }
            }
            if (maxIdx == i) {
                continue;
            }

            int maxval = arrInt[maxIdx];
            for (int j = maxIdx; j > i; j--) {
                arrInt[j] = arrInt[j - 1];
            }
            arrInt[i] = maxval;
            s = s - (maxIdx - i);
        }

        StringBuilder bs = new StringBuilder();
        for (int i = 0; i < n; i++) {
            bs.append(arrInt[i]).append(" ");
        }

        System.out.println(bs.toString().trim());
    }

}
