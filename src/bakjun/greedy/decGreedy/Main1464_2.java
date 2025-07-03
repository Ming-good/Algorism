package bakjun.greedy.decGreedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main1464_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();

        Deque<Character> que = new ArrayDeque();
        for (char ch : chars) {
            if (que.isEmpty()) {
                que.offer(ch);
                continue;
            }

            if (que.getFirst() >= ch) {
                que.addFirst(ch);
            } else  {
                que.addLast(ch);
            }
        }

        que.stream().forEach(ch -> System.out.print(ch));
    }
}
