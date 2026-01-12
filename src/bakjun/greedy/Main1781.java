package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main1781 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] homeworks = new long[n][2];

        for (int i=0;i<n;i++) {
            String[] homeworkTokken = br.readLine().split(" ");
            homeworks[i][0] = Long.parseLong(homeworkTokken[0]);
            homeworks[i][1] = Long.parseLong(homeworkTokken[1]);
        }

        Arrays.sort(homeworks, (a, b) -> {
            if(a[0] == b[0]) {
                return Long.compare(b[1], a[1]);
            }

            return Long.compare(a[0], b[0]);
        });

        PriorityQueue<Long> que = new PriorityQueue<>();

        for (int i=0;i<n;i++) {
            long deadLine = homeworks[i][0];
            long reward = homeworks[i][1];

            que.add(reward);
            if(que.size() > deadLine) {
                que.poll();
            }
        }

        long cnt = 0;
        while(!que.isEmpty()) {
            cnt += que.poll();
        }

        System.out.println(cnt);
    }
}
