package bakjun.greedy.decGreedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main1464 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chArr = br.readLine().toCharArray();
        Deque<Character> dq = new ArrayDeque<>();

        for (char c : chArr) {
            if (dq.isEmpty() || c <= dq.peekFirst()) {
                dq.addFirst(c);      // push_front
            } else {
                dq.addLast(c);       // push_back
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst());
        }

        System.out.println(sb);
    }

}
