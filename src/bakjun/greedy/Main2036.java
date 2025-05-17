package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main2036 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long size = Integer.parseInt(br.readLine());

        PriorityQueue<Long> minusPq = new PriorityQueue<>();
        PriorityQueue<Long> plusPq = new PriorityQueue<>(Collections.reverseOrder());

        long ones = 0;

        for (long i = 0; i < size; i++) {
            long n = Long.parseLong(br.readLine());

            if (n == 1) {
                ones += n;
                continue;
            }

            if (n > 1) {
                plusPq.offer(n);
                continue;
            }
            minusPq.offer(n);
        }

        long totalNum = 0;
        while (plusPq.size()>1) {
            Long a = plusPq.poll();
            Long b = plusPq.poll();
            totalNum += a*b;
        }

        if (!plusPq.isEmpty()) {
            totalNum += plusPq.poll();
        }

        while (minusPq.size()>1) {
            Long a = minusPq.poll();
            Long b = minusPq.poll();
            totalNum += a * b;
        }
        if (!minusPq.isEmpty()) {
            totalNum += minusPq.poll();
        }
        System.out.println(totalNum+ones);

    }

}
