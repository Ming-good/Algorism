package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main19644 {
    static int boomCnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] guns = br.readLine().split(" ");
        int distance = Integer.parseInt(guns[0]);
        int damege = Integer.parseInt(guns[1]);
        boomCnt = Integer.parseInt(br.readLine());

        boolean die = false;
        int[] usageBoom = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int enumy = Integer.parseInt(br.readLine());
            if (die) {
                continue;
            }
            int usageBoomCnt = usageBoom[i - 1] - usageBoom[Math.max(0, i - distance)];
            int inRangeDamege = (Math.min(i, distance)-usageBoomCnt) * damege;

            if (enumy<=inRangeDamege) {
                usageBoom[i] = usageBoom[i - 1];
                continue;
            }

            if (enumy>inRangeDamege && boomCnt > 0) {
                boomCnt--;
                usageBoom[i] = usageBoom[i - 1] + 1;
                continue;
            }

            die = true;
        }

        System.out.println(!die ? "YES" : "NO");
    }

}
