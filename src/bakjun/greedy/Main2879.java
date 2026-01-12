package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2879 {
    public static int gi;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] currentTokken = br.readLine().split(" ");
        String[] targetTokken = br.readLine().split(" ");

        int[] currentCnt = new int[n];
        int[] targetCnt = new int[n];
        for (int i=0;i<n;i++){
            currentCnt[i] = Integer.parseInt(currentTokken[i]);
            targetCnt[i] = Integer.parseInt(targetTokken[i]);
        }

        int totalCnt = 0;
        for (gi=0;gi<n;gi=gi) {
            int start = gi;
            totalCnt += cal(n, currentCnt, targetCnt);
            totalCnt += cal(n, targetCnt, currentCnt);

            if (start == gi) {
                gi++;
            }
        }

        System.out.println(totalCnt);

    }
    public static int cal(int n, int[] current, int[] target) {
        int prevGap = 0;
        int cnt = 0;
        while (gi<n && current[gi]>target[gi]) {
            int currGap = current[gi] - target[gi];
            if (currGap > prevGap) {
                cnt += (currGap - prevGap);
            }
            prevGap = currGap;
            gi++;
        }
        return cnt;
    }

}
