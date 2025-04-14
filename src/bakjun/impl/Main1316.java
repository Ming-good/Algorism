package bakjun.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (isGroup(br.readLine())) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static boolean isGroup(String word) {
        Set<Character> set = new HashSet<>();
        char beforeChar = 0;
        for (char ch : word.toCharArray()) {
            if (!set.contains(ch)) {
                set.add(ch);
                beforeChar = ch;
                continue;
            }

            if (set.contains(ch) && beforeChar == ch) {
                continue;
            }

            return false;
        }

        return true;
    }
}
