package bakjun.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main28278 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            switch (s[0]) {
                case "1":stack.add(s[1]);
                    break;
                case "2":
                    System.out.println(stack.size() < 1 ? -1 : stack.pop());
                    break;
                case "3":
                    System.out.println(stack.size());
                    break;
                case "4":
                    System.out.println(stack.size()<1 ? 1 : 0);
                    break;
                case "5":
                    System.out.println(stack.size()<1?-1:stack.peek());
                    break;
            }
        }
    }
}
