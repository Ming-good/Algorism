package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1132 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] arr = new long[100][2];

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            int size = chars.length;
            arr[chars[0]][1] = 1;
            for (int z = 0; z < size; z++) {
                arr[chars[z]][0] += powToLoop(size-z);
            }
        }

        Arrays.sort(arr, (a,b) -> Long.compare(b[0],a[0]));

        if (arr[9][0] > 0) {
            for (int i = 9; i >= 0; i--) {
                if (arr[i][1] == 0) {
                    arr[i][0] = 0;
                    break;
                }
            }
        }

        long sum = 0;
        long id = 9;
        for (int i = 0; i < 10; i++) {
            if (arr[i][0] == 0) continue;

           sum += arr[i][0] * id--;
        }

        System.out.println(sum);
    }

    public static long powToLoop(int size) {
        long n = 1;
        for (int i = 1; i < size; i++) {
            n *= 10L;
        }
        return n;
    }

}
