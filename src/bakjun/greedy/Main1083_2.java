package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1083_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int s = Integer.parseInt(br.readLine());

        int[] intArr = new int[n];
        for (int i = 0; i < n; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }


        for (int i = 0; i < n && 0 < s; i++) {
            int maxi=i;
            for (int j = i+1; j < n && j-i<=s; j++) {
                if (intArr[maxi] < intArr[j]) {
                    maxi = j;
                }
            }

            if (maxi == i) continue;

            int maxVal = intArr[maxi];
            for (int j = maxi; j>i; j--) {
                intArr[j] = intArr[j-1];
            }
            intArr[i] = maxVal;
            s=s-(maxi-i);
        }

        StringBuilder bs = new StringBuilder();
        for (int a : intArr) {
            bs.append(a).append(" ");
        }

        System.out.println(bs.toString().trim());

    }

}
