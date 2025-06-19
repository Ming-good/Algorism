package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            int leftPalindrome = isLeftPalindrome(str);
            int rightPalindrome = isRightPalindrome(str);

            if (leftPalindrome + rightPalindrome == 0) {
                sb.append(0).append("\n");
                continue;
            }
            if (leftPalindrome + rightPalindrome <= 3) {
                sb.append(1).append("\n");
                continue;
            }
            sb.append(2).append("\n");
        }
        System.out.println(sb);
    }

    private static int isLeftPalindrome(String str) {
        boolean isNearPaindrome = false;
        int cursor = str.length()-1;
        for (int i = 0; i < cursor; i++) {
            char left = str.charAt(i);
            char right = str.charAt(cursor);
            if (left == right) {
                cursor--;
                continue;
            }
            if (isNearPaindrome) {
                return 2;
            }
            isNearPaindrome = true;
        }
        return isNearPaindrome?1:0;
    }

    private static int isRightPalindrome(String str) {
        boolean isNearPaindrome = false;
        int cursor = 0;
        for (int i = str.length()-1; i > cursor; i--) {
            char left = str.charAt(cursor);
            char right = str.charAt(i);
            if (left == right) {
                cursor++;
                continue;
            }
            if (isNearPaindrome) {
                return 2;
            }
            isNearPaindrome = true;
        }
        return isNearPaindrome?1:0;
    }
}

