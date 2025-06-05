package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/9082
public class Main9082 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] result = new int[T];

        for (int j = 0; j < T; j++) {
            int N = Integer.parseInt(br.readLine());
            int[] booms = new int[N];

            String line = br.readLine();br.readLine();

            for (int i = 0; i < N; i++) {
                booms[i] = line.charAt(i) - '0';
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (i==0 && booms[i]>0) {
                    cnt++;
                    booms[i]--;
                    if (N>1) booms[i+1]--;
                } else if (booms[i] > 0 && i == N-1) {
                    cnt++;
                    booms[i-1]--;
                    booms[i]--;
                } else if (i < N-1 && i>0 && booms[i - 1] > 0) {
                    cnt++;
                    booms[i-1]--;
                    booms[i]--;
                    booms[i+1]--;
                }
            }

            result[j] = cnt;
        }

        for (int i = 0; i < T; i++) {
            System.out.println(result[i]);
        }

    }
}
