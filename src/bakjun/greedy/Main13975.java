package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            StringTokenizer token = new StringTokenizer(br.readLine());

            PriorityQueue<Long> que = new PriorityQueue<>();
            for (int j = 0; j < k; j++) {
                que.offer(Long.parseLong(token.nextToken()));
            }

            sb.append(countPage(que)).append("\n");
        }
        System.out.println(sb);
    }

    private static long countPage(PriorityQueue<Long> book) {
        long sum = 0;
        while(book.size()>1) {
            long a = book.poll();
            long b = book.poll();
            sum += a+b;
            book.add(a+b);
        }
        return sum;
    }
}
