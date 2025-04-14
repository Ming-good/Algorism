package bakjun.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11729 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb.append((int) (Math.pow(2, N) - 1)).append('\n');
        move(N, 1, 3, 2);

        System.out.println(sb);

    }


    private static void move(int n, int from, int to, int temp) {
        if (n == 0) {
            return;
        }
        // 1. n-1개를 보조 기둥으로
        move(n - 1, from, temp, to);

        // 2. 가장 큰 디스크 1개 이동
        sb.append(from).append(' ').append(to).append('\n');

        // 3. n-1개를 목적지 기둥으로
        move(n - 1, temp, to, from);
    }
}
