package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2879_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] currentTokken = br.readLine().split(" ");
        String[] targetTokken = br.readLine().split(" ");
        int[] distance = new int[n];

        int a,b;
        for (int i=0;i<n;i++) {
            a = Integer.parseInt(currentTokken[i]);
            b = Integer.parseInt(targetTokken[i]);
            distance[i] = a-b;
        }

        int cnt = 0;
        int prev = 0;
        for (int i=0;i<n;i++) {
            int absCurrentDistance = Math.abs(distance[i]);
            int absPrevDistance = Math.abs(prev);
            if (distance[i]*prev<=0) {
                cnt += absCurrentDistance;
            } else {
                if (absCurrentDistance > absPrevDistance) {
                    cnt += (absCurrentDistance - absPrevDistance);
                }
            }
            prev = distance[i];

        }

        System.out.println(cnt);
    }
}
