package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main1374 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] lecture = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] tokken = br.readLine().split(" ");
            lecture[i][0] = Integer.parseInt(tokken[1]);
            lecture[i][1] = Integer.parseInt(tokken[2]);
        }

        Arrays.sort(lecture, (a,b) -> {
            if (a[0] == b[0]) {
               return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue.offer(lecture[0][1]);
        for (int i=1;i<n;i++) {
            if (queue.peek() <= lecture[i][0]) {
                queue.poll();
            }
            queue.offer(lecture[i][1]);
        }
        System.out.println(queue.size());
    }
}
