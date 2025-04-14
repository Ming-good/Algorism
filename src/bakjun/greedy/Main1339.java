package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1339 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];

        long[] weightArr = new long[26];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
            char[] charArray = str[i].toCharArray();
            int len = str[i].length();
            for (int j = 0; j< len; j++) {
                int pos = len-j-1;
                weightArr[charArray[j]-'A'] += Math.pow(10, pos);
            }
        }

        Arrays.sort(weightArr);
        int digit = 9;
        int sum = 0;
        for (int i = weightArr.length - 1; i >= 0 && digit >= 0; digit--, i--) {
            if (weightArr[i] == 0) break;
            sum += weightArr[i] * digit;
        }
        System.out.println(sum);
    }
}
