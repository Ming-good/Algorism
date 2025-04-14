package bakjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1904 {

    static int[] seqArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        seqArr = new int[2+n+1];
        seqArr[1] = 1;
        seqArr[2] = 2;
        for (int i = 3; i <= n; i++) {
            seqArr[i] = (seqArr[i - 1] + seqArr[i - 2])%15746;
        }

        System.out.println(seqArr[n]);
    }
}
