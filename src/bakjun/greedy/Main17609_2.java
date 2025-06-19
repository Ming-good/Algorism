package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// https://www.acmicpc.net/problem/17609
public class Main17609_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            sb.append(classfy(str)).append("\n");
        }
        System.out.println(sb);
    }

    private static int classfy(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r && str.charAt(l) == str.charAt(r)) {
            l++;
            r--;
        }
        if (l>= r)
            return 0;

        if (isPalindrome(str,l+1,r) || isPalindrome(str,l,r-1)) {
            return 1;
        }

        return 2;
    }

    private static boolean isPalindrome(String str, int l, int r) {
        while (l<r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;r--;
        }
        return true;
    }
}// abcxxeba
